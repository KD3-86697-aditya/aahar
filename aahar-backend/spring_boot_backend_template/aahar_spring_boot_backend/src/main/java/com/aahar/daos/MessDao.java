package com.aahar.daos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.MealType;
import com.aahar.pojos.Mess;
import com.aahar.pojos.User;

import java.awt.MenuItem;
import java.util.List;
import java.util.Optional;

@Repository
public interface MessDao extends JpaRepository<Mess, Long> {

	Optional<Mess> findByMessOwner(User messOwner);
	
    Optional<Mess> findByMessOwnerId(Long messOwnerId);
	
	
    List<Mess> findByLocationCity(String city);
//	List<Mess> findByMenuItems_MealType(MealType \mealType);

	
	//searching and filtering the mess based on the address or messname and mealType
	
	List<Mess> findByMessNameContainingOrAddressContaining(String messName, String address);
	
//	@Query("SELECT DISTINCT m FROM Mess m JOIN m.menuItems mi WHERE mi.mealType = :mealType")
//	    List<Mess> findByMealType(@Param("mealType") MealType mealType);
	
//	@Query("SELECT m FROM Mess m JOIN m.menuItems mi WHERE mi.mealType = :mealType")
//	List<Mess> findByMealType(@Param("mealType") MealType mealType);

	  @Query("SELECT mi FROM MenuItem mi WHERE mi.mess.id = :messId")
	    List<MenuItem> findMenuItemsByMessId(@Param("messId") Long messId);
	
    // Find all messes owned by a specific mess owner
//    List<Mess> findByMessOwner(User messOwner);
//
//    // Find mess by name
//    Optional<Mess> findByName(String name);
//
//    // Check if a mess exists for a given owner
//    boolean existsByMessOwner(User messOwner);
   
}
