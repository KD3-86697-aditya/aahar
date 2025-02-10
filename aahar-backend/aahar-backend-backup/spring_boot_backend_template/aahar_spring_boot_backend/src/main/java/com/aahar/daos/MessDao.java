package com.aahar.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.Mess;
import com.aahar.pojos.User;

import java.awt.MenuItem;
import java.util.List;
import java.util.Optional;

@Repository
public interface MessDao extends JpaRepository<Mess, Long> {

	Optional<Mess> findByMessOwner(User messOwner);
	
    Optional<Mess> findByMessOwnerId(Long messOwnerId);
	
    @Query("SELECT m FROM Mess m JOIN FETCH m.messOwner WHERE m.id = :messId")
    Mess findMessWithOwnerDetails(Long messId);
	
    // Find all messes owned by a specific mess owner
//    List<Mess> findByMessOwner(User messOwner);
//
//    // Find mess by name
//    Optional<Mess> findByName(String name);
//
//    // Check if a mess exists for a given owner
//    boolean existsByMessOwner(User messOwner);
    
    
    List<Mess> findByLocationCity(String city);

    
    @Query("SELECT mi FROM MenuItem mi WHERE mi.mess.id = :messId")
    List<com.aahar.pojos.MenuItem> findMenuItemsByMessId(@Param("messId") Long messId);

	List<Mess> findByMessNameContainingOrAddressContaining(String messName, String address);
   
}
