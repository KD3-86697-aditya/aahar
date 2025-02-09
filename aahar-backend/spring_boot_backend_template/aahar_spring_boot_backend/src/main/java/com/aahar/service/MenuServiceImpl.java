package com.aahar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.daos.DishDao;
import com.aahar.daos.MenuItemDao;
import com.aahar.daos.MessDao;
import com.aahar.daos.NutritionalInfoDao;
import com.aahar.daos.WeeklyMenuDao;
import com.aahar.daos.WeeklyMenuItemsDao;
import com.aahar.dtos.MenuItemReqDTO;
import com.aahar.dtos.MenuItemRespDTO;
import com.aahar.dtos.MenuItemUpdateRequest;
import com.aahar.dtos.NutritionalInfoDTO;
import com.aahar.pojos.DayOfWeek;
import com.aahar.pojos.Dish;
import com.aahar.pojos.MealType;
import com.aahar.pojos.MenuItem;
import com.aahar.pojos.Mess;
import com.aahar.pojos.NutritionalInfo;
import com.aahar.pojos.WeeklyMenu;
import com.aahar.pojos.WeeklyMenuItem;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuItemDao menuItemDao;

	@Autowired
	private MessDao messDao;

	@Autowired
	private WeeklyMenuDao weeklyMenuDao;

	@Autowired
	private NutritionalInfoDao nutritionalInfoDao;
	
	@Autowired
	private WeeklyMenuItemsDao weeklyMenuItemsDao;

	@Autowired
	private DishDao dishDao;

	public List<MenuItemRespDTO> getWeeklyMenu(Long messOwnerId) {
		// Get the mess for the given messOwnerId
		Mess mess = messDao.findByMessOwnerId(messOwnerId)
				.orElseThrow(() -> new RuntimeException("Mess not found for owner"));

		// Fetch all WeeklyMenus for the given Mess
		List<WeeklyMenu> weeklyMenus = weeklyMenuDao.findByMessId(mess.getId());

		// Now, for each WeeklyMenu, fetch the corresponding WeeklyMenuItems
		List<MenuItemRespDTO> responses = new ArrayList<>();

		for (WeeklyMenu weeklyMenu : weeklyMenus) {
			List<WeeklyMenuItem> weeklyMenuItems = weeklyMenuItemsDao.findByWeeklyMenu(weeklyMenu);
			for (WeeklyMenuItem weeklyMenuItem : weeklyMenuItems) {
				responses.add(mapToMenuItemResponse(weeklyMenuItem));
			}
		}

		return responses;
	}

	// Map WeeklyMenuItems to MenuItemResponse
	private MenuItemRespDTO mapToMenuItemResponse(WeeklyMenuItem weeklyMenuItem) {
		MenuItem item = weeklyMenuItem.getMenuItem();

		return new MenuItemRespDTO(item.getId(), weeklyMenuItem.getWeeklyMenu().getWeekday().name(),
				item.getDish().getName(), item.getPrice(), item.getIsAvailable());
	}

//    @Override
//    public MenuItemRespDTO addMenuItem(Long messOwnerId, String dishName, double price, DayOfWeek dayOfWeek,MealType mealType) {
//        // Find the mess associated with the messOwnerId
//        Mess mess = messDao.findByMessOwnerId(messOwnerId)
//                .orElseThrow(() -> new RuntimeException("Mess not found for owner"));
//
//        // Find or create a WeeklyMenu for the given mess and day
//        WeeklyMenu weeklyMenu = weeklyMenuDao.findByMessIdAndWeekday(mess.getId(), dayOfWeek)
//                .orElseGet(() -> {
//                    WeeklyMenu newMenu = new WeeklyMenu();
//                    newMenu.setMess(mess);
//                    newMenu.setWeekday(dayOfWeek);
//                    return weeklyMenuDao.save(newMenu);
//                });
//
//        // Fetch the Dish entity
//        Dish dish = dishDao.findByName(dishName)
//                .orElseThrow(() -> new RuntimeException("Dish not found"));
//
//        // Create a new MenuItem
//        MenuItem menuItem = new MenuItem();
//        menuItem.setDish(dish);
//        menuItem.setMess(mess);
//        menuItem.setPrice(price);
//        menuItem.setMealType(mealType);  // ✅ Directly using the enum
//        menuItem.setIsAvailable(true);
//        menuItem = menuItemDao.save(menuItem);
//
//        // Link the MenuItem with WeeklyMenu
//        WeeklyMenuItem weeklyMenuItem = new WeeklyMenuItem();
//        weeklyMenuItem.setWeeklyMenu(weeklyMenu);
//        weeklyMenuItem.setMenuItem(menuItem);
//        weeklyMenuItemsDao.save(weeklyMenuItem);
//
//        return new MenuItemRespDTO(
//                menuItem.getId(),
//                dayOfWeek.name(),
//                menuItem.getDish().getName(),
//                menuItem.getPrice(),
//                menuItem.getIsAvailable()
//        );
//    }

	@Override
	public void updateMenuItem(MenuItemUpdateRequest updateRequest) {
		Optional<MenuItem> existingItemOpt = menuItemDao.findById(updateRequest.getId());

		if (existingItemOpt.isPresent()) {
			MenuItem menuItem = existingItemOpt.get();

			// Find or create a dish with the updated name
			Dish dish = dishDao.findByName(updateRequest.getDishName()).orElseGet(() -> {
				Dish newDish = new Dish();
				newDish.setName(updateRequest.getDishName());
				return dishDao.save(newDish);
			});

			// Update menu item details
			menuItem.setDish(dish);
			menuItem.setPrice(updateRequest.getPrice());
			menuItem.setMealType(MealType.valueOf(updateRequest.getMealType().toUpperCase()));

			menuItemDao.save(menuItem);
		} else {
			throw new RuntimeException("Menu item not found");
		}
	}

	@Override
	public boolean deleteMenuItem(Long menuItemId) {
		Optional<MenuItem> menuItemOpt = menuItemDao.findById(menuItemId);

		if (menuItemOpt.isEmpty()) {
			throw new RuntimeException("Menu item not found");
		}

		MenuItem menuItem = menuItemOpt.get();

		// Delete related WeeklyMenuItems
		weeklyMenuItemsDao.deleteByMenuItem(menuItem);

		// Now delete the menu item itself
		menuItemDao.delete(menuItem);

		return true;
	}

	@Override
	public MenuItemRespDTO addMenuItem(Long messOwnerId, MenuItemReqDTO requestDTO,NutritionalInfoDTO nutritionalInfoDTO) {
		
		// Fetch mess and weekly menu in one line with fallback logic
		Mess mess = messDao.findByMessOwnerId(messOwnerId)
				.orElseThrow(() -> new RuntimeException("Mess not found for owner"));

		WeeklyMenu weeklyMenu = weeklyMenuDao
				.findByMessIdAndWeekday(mess.getId(), DayOfWeek.valueOf(requestDTO.getDayOfWeek().toUpperCase()))
				.orElseGet(() -> weeklyMenuDao
						.save(new WeeklyMenu(mess, DayOfWeek.valueOf(requestDTO.getDayOfWeek().toUpperCase()))));

		// Fetch dish by ID
		Dish dish = dishDao.findById(requestDTO.getDishId()).orElseThrow(() -> new RuntimeException("Dish not found"));

		// Create and save the menu item
		MenuItem menuItem = new MenuItem();
		menuItem.setDish(dish);
		menuItem.setMess(mess);
		menuItem.setPrice(requestDTO.getPrice());
		menuItem.setMealType(MealType.valueOf(requestDTO.getMealType().toUpperCase()));
		menuItem.setIsAvailable(true);
		menuItem = menuItemDao.save(menuItem);

	    // Save Nutritional Info
	    NutritionalInfo nutritionalInfo = new NutritionalInfo();
	    nutritionalInfo.setMenuItem(menuItem);
	    nutritionalInfo.setCaloriesPerServing(nutritionalInfoDTO.getCaloriesPerServing());
	    nutritionalInfo.setProteinPerServing(nutritionalInfoDTO.getProteinPerServing());
	    nutritionalInfo.setCarbohydratesPerServing(nutritionalInfoDTO.getCarbohydratesPerServing());
	    nutritionalInfo.setFatPerServing(nutritionalInfoDTO.getFatPerServing());
	    nutritionalInfoDao.save(nutritionalInfo); 
	    
	    // Save the nutritional information
        // Link the MenuItem with WeeklyMenu
		WeeklyMenuItem weeklyMenuItem = new WeeklyMenuItem();
		weeklyMenuItem.setWeeklyMenu(weeklyMenu);
		weeklyMenuItem.setMenuItem(menuItem);
		weeklyMenuItemsDao.save(weeklyMenuItem);

		// Return response DTO
		return new MenuItemRespDTO(menuItem.getId(), requestDTO.getDayOfWeek().toUpperCase(), dish.getName(), menuItem.getPrice(),
				menuItem.getIsAvailable());
	}

}
