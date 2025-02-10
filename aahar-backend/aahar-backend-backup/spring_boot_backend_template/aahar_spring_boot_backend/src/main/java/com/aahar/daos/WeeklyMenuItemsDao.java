package com.aahar.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.MenuItem;
import com.aahar.pojos.WeeklyMenu;
import com.aahar.pojos.WeeklyMenuItem;

@Repository
public interface WeeklyMenuItemsDao extends JpaRepository<WeeklyMenuItem, Long> {
	
    List<WeeklyMenuItem> findByWeeklyMenu(WeeklyMenu weeklyMenu);
    
    
    // Fetch all menu items for a specific day
    @Query("SELECT wmi FROM WeeklyMenuItem wmi WHERE wmi.weeklyMenu.weekday = :dayOfWeek")
    List<WeeklyMenuItem> findByDayOfWeek(@Param("dayOfWeek") WeeklyMenu.DayOfWeek dayOfWeek);

    
    @Query("SELECT wmi FROM WeeklyMenuItem wmi WHERE wmi.weeklyMenu.mess.messOwner.id = :messOwnerId")
    List<WeeklyMenuItem> findByMessOwnerId(@Param("messOwnerId") Long messOwnerId);
    
    Optional<WeeklyMenuItem> findByMenuItem(MenuItem menuItem);
    
    void deleteByMenuItem(MenuItem menuItem);



}