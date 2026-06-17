package com.example.vehicle_dealership.repositories;

import com.example.vehicle_dealership.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface vehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByVinContainingIgnoreCase(String vin);

    List<Vehicle> findByVehicleColorContainingIgnoreCase(String vehicleColor);

    List<Vehicle> findByMakeContainingIgnoreCase(String make);

    List<Vehicle> findByModelContainingIgnoreCase(String model);

    List<Vehicle> findByVehicleTypeContainingIgnoreCase(String vehicleType);
//
//    List<Vehicle> findByPriceContainingIgnoreCase(String price);
//
//    List<Vehicle> findByYearContainingIgnoreCase(String year);
//
//    List<Vehicle> findByOdometerContainingIgnoreCase(String odometer);


}
