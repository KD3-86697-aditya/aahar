package com.aahar.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.DayOfWeek;
import com.aahar.pojos.WeeklyMenu;

@Repository
public interface WeeklyMenuDao extends JpaRepository<WeeklyMenu, Long> {
    Optional<WeeklyMenu> findByMessIdAndWeekday(Long messId, DayOfWeek weekday);
    
   List<WeeklyMenu> findByMessId(Long messId);
}
