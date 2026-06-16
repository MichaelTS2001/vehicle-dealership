package com.example.vehicle_dealership.repositories;

import com.example.vehicle_dealership.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface VDRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByNameContainingIgnorePrice(String name);
}
