package com.aahar.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.entity.StaffMembers;

public interface StaffMembersRepository extends JpaRepository<StaffMembers , Long> {
	Optional<StaffMembers> findByMobileNo(String mobileNo);
}


