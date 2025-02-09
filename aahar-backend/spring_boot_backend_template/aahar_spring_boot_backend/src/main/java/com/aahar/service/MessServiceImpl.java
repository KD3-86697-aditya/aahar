package com.aahar.service;

import java.awt.MenuItem;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aahar.custom_exceptions.ResourceNotFoundException;
import com.aahar.daos.LocationDao;
import com.aahar.daos.MessDao;
import com.aahar.daos.UserDao;
import com.aahar.dtos.ApiResponse;
import com.aahar.dtos.LocationDTO;
import com.aahar.dtos.MenuItemRespDTO;
import com.aahar.dtos.MessReqDTO;
import com.aahar.dtos.MessRespDTO;
import com.aahar.dtos.UserDTO;
import com.aahar.pojos.Location;
import com.aahar.pojos.MealType;
import com.aahar.pojos.Mess;
import com.aahar.pojos.User;
import com.aahar.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessServiceImpl implements MessService {

	@Autowired
	private MessDao messDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	 public ApiResponse addMess(MessReqDTO messDTO) {
        // Fetch the mess owner (User) and location
        User messOwner = userDao.findById(messDTO.getMessOwnerId())
                                       .orElseThrow(() -> new ResourceNotFoundException("User not found"));
       
        Location location=locationDao.findById(messDTO.getLocationId()).orElseThrow(()-> new ResourceNotFoundException("location not found"));
        Optional<Mess> existingMess = messDao.findByMessOwner(messOwner);
        
        if(messOwner.getRole()!=UserRole.MESS_OWNER)
        {
        	return new ApiResponse("only user with role as messowner can register his mess");

        }
        
        if (existingMess.isPresent()) {
            return new ApiResponse("A mess owner can have only one mess . Update the existing mess instead.");
        } 
        else
        {
        	Mess messEntity=mapper.map(messDTO, Mess.class);
        	
        	messEntity.setLocation(location);
        	messEntity.setMessOwner(messOwner);
        	
        	Mess persistentMess=messDao.save(messEntity);
        	
        	return new ApiResponse("Added mess succesfully with id = " + persistentMess.getId());
        	
        }

     
    }


	@Override
	public List<MessRespDTO> getMessesByCity(String city) {
		List<Mess> messList =  messDao.findByLocationCity(city);
		return messList.stream().map(mess-> mapper.map(mess, MessRespDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<MessRespDTO> searchMesses(String query) {
		List<Mess> messList= messDao.findByMessNameContainingOrAddressContaining(query, query);
		return messList.stream().map(mess-> mapper.map(mess, MessRespDTO.class)).collect(Collectors.toList());
	}

	@Override
	public MessRespDTO getMessDetails(Long messId) {
		Mess mess = messDao.findById(messId).orElseThrow(() -> new RuntimeException("Mess Not Found"));
		return mapper.map(mess, MessRespDTO.class);
	}

//	@Override
//	public List<MessRespDTO> filterMessesByMealType(MealType mealType) {
//	 List<Mess> messList =  messDao.findByMealType(mealType);
//	 return messList.stream().map(mess -> mapper.map(mess, MessRespDTO.class )).collect(Collectors.toList());
//	}




	@Override
	public ApiResponse updateMess(Long messId, MessReqDTO messDTO) {
	    Mess mess = messDao.findById(messId)
	        .orElseThrow(() -> new ResourceNotFoundException("Mess not found"));

	    User messOwner = userDao.findById(messDTO.getMessOwnerId())
	        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
	    
	    Location location=locationDao.findById(messDTO.getLocationId()).orElseThrow(()-> new ResourceNotFoundException("location not found "));

	    // Ensure only the mess owner can update their own mess
	    if (!mess.getMessOwner().getId().equals(messDTO.getMessOwnerId())) {
	        return new ApiResponse("You can only update your own mess");
	    }

	    // Update mess details
	    mess.setMessName(messDTO.getMessName());
	    mess.setAddress(messDTO.getAddress());
	    mess.setDescription(messDTO.getDescription());
	    mess.setContactNumber(messDTO.getContactNumber());
	    mess.setOpeningHours(messDTO.getOpeningHours());
	    mess.setLocation(location);

	    messDao.save(mess);
	    return new ApiResponse("Mess updated successfully");
	}


	@Override
	public List<MessRespDTO> getAllMesses() {
		
		List<Mess> messList=messDao.findAll();		
		
		return messList.stream().map(mess-> 
		{
			MessRespDTO dto=mapper.map(mess, MessRespDTO.class);
			dto.setLocation(mapper.map(mess.getLocation(), LocationDTO.class));
			dto.setMessOwnerId(mess.getMessOwner().getId());
			
			return dto;
		}).collect(Collectors.toList());
	}


	@Override
	public ApiResponse deleteMess(Long messId) {
		
	    Mess mess = messDao.findById(messId)
	        .orElseThrow(() -> new ResourceNotFoundException("Mess not found"));
	    mess.softDelete();
	    messDao.save(mess); // Update in DB
	    return new ApiResponse("Mess deleted succesfully");
	    
	}
	
	 public List<MenuItemRespDTO> getMenuItems(Long messId) {
	        List<MenuItem> menuList = messDao.findMenuItemsByMessId(messId);
	        return menuList.stream().map(menu -> mapper.map(menu, MenuItemRespDTO.class)).collect(Collectors.toList());
	    }
}
