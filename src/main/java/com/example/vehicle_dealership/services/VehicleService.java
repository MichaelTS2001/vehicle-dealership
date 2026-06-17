package com.example.vehicle_dealership.services;

import com.example.vehicle_dealership.entities.Vehicle;
import com.example.vehicle_dealership.repositories.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private vehicleRepository vehicleRepository;

    //get All Vehicles
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        return vehicleList;
    }

    //Search for a Vehicle by vin
    public List<Vehicle> searchByVin(String vin){

        return vehicleRepository.findByVinContainingIgnoreCase(vin);
    }

    //Search for a Vehicle by color
    public List<Vehicle> searchByColor(String vehicleColor){
        return vehicleRepository.findByVehicleColorContainingIgnoreCase(vehicleColor);
    }

    //Search for a Vehicle by make
    public List<Vehicle> searchByMake(String make){
        return vehicleRepository.findByMakeContainingIgnoreCase(make);
    }

    //Find a vehicle by their ID
    public Optional<Vehicle> getVehicleId(Long id){
        var vehicle = vehicleRepository.findById(id);

        return vehicle;
    }

    //Delete Vehicle
    public boolean delete(Long id){
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findById(id);

        if(vehicleToDelete.isEmpty()){
            return false;
        }

        vehicleRepository.delete(vehicleToDelete.get());
        return true;
    }

    public Vehicle create(Vehicle vehicle){
        Vehicle newVehicle = vehicleRepository.save(vehicle);

        return newVehicle;
    }

    public Vehicle update(Long id, Vehicle vehicle){
        //look to see if there is a vehicle with that id
        Optional<Vehicle> updateVehicle = vehicleRepository.findById(id);

        if(updateVehicle.isEmpty()){
            return null;
        }

        //now update everything to the new value
        Vehicle vehicleToUpdate = updateVehicle.get();

        vehicleToUpdate.setMake(vehicle.getMake());
        vehicleToUpdate.setModel(vehicle.getModel());
        vehicleToUpdate.setVehicleType(vehicle.getVehicleType());
        vehicleToUpdate.setYear(vehicle.getYear());
        vehicleToUpdate.setVin(vehicle.getVin());
        vehicleToUpdate.setVehicleColor(vehicle.getVehicleColor());
        vehicleToUpdate.setVehicleOdometer(vehicle.getVehicleOdometer());
        vehicleToUpdate.setVehiclePrice(vehicle.getVehiclePrice());

        vehicleRepository.save(vehicleToUpdate);

        return vehicleToUpdate;
    }



}
