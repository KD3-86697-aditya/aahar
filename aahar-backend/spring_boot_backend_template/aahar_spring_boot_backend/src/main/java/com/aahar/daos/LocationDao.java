package com.aahar.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aahar.pojos.Location;

public interface LocationDao extends JpaRepository<Location, Long>{
    List<Location> findByCity(String city);

}
