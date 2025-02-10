package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.pojos.Dish;
import java.util.Optional;


public interface DishDao extends JpaRepository<Dish, Long>  {
	

	Optional<Dish> findByName(String name);

}
