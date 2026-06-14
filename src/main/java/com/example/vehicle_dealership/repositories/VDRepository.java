package com.example.vehicle_dealership.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface VDRepository extends JpaRepository<Vehicle, String> {

    List<Vehicle> findByVehicleNameContainingIgnoreCase(String name);


}
