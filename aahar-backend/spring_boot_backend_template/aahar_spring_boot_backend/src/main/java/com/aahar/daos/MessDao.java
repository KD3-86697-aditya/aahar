package com.aahar.daos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aahar.pojos.Mess;
import com.aahar.pojos.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessDao extends JpaRepository<Mess, Long> {

	Optional<Mess> findByMessOwner(User messOwner);
	
    Optional<Mess> findByMessOwnerId(Long messOwnerId);
	
	
	
    // Find all messes owned by a specific mess owner
//    List<Mess> findByMessOwner(User messOwner);
//
//    // Find mess by name
//    Optional<Mess> findByName(String name);
//
//    // Check if a mess exists for a given owner
//    boolean existsByMessOwner(User messOwner);
   
}
