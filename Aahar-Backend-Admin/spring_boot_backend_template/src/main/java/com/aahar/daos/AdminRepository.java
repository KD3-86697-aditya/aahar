package com.aahar.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aahar.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin , Long>{
	Optional<Admin> findByAdminname(String Adminname);
	boolean existsByAdminname(String Adminname);
}
