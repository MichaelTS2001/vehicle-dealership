package com.example.vehicle_dealership.services;

import com.example.vehicle_dealership.entities.Vehicle;
import com.example.vehicle_dealership.repositories.VDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VDRepository vdRepository;

    //get All Vehicles
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicleList = vdRepository.findAll();

        return vehicleList;
    }

    //Search for a Vehicles
    public List<Vehicle> searchVehicles(String vehicleVin){
        return vdRepository.findByNameContainingIgnorePrice(vehicleVin);
    }

    //Find a vehicle by their ID
    public Optional<Vehicle> getVehicleId(Long id){
        var vehicle = vdRepository.findById(id);

        return vehicle;
    }

    //Delete Vehicle
    public boolean delete(Long id){
        Optional<Vehicle> vehicleToDelete = vdRepository.findById(id);

        if(vehicleToDelete.isEmpty()){
            return false;
        }

        vdRepository.delete(vehicleToDelete.get());
        return true;
    }

    public Vehicle create(Vehicle vehicle){
        Vehicle newVehicle = vdRepository.save(vehicle);

        return newVehicle;
    }

    public Vehicle update(Long id, Vehicle vehicle){
        //look to see if there is a vehicle with that id
        Optional<Vehicle> updateVehicle = vdRepository.findById(id);

        if(updateVehicle.isEmpty()){
            return null;
        }

        //now update everything to the new value
        Vehicle vehicleToUpdate = updateVehicle.get();

        vehicleToUpdate.setMake(vehicle.getMake());
        vehicleToUpdate.setModel(vehicle.getModel());
        vehicleToUpdate.setVehicleModel(vehicle.getVehicleModel());
        vehicleToUpdate.setYear(vehicle.getYear());
        vehicleToUpdate.setVIN(vehicle.getVIN());
        vehicleToUpdate.setVehicleColor(vehicle.getVehicleColor());
        vehicleToUpdate.setVehicleOdometer(vehicle.getVehicleOdometer());
        vehicleToUpdate.setVehiclePrice(vehicle.getVehiclePrice());

        vdRepository.save(vehicleToUpdate);

        return vehicleToUpdate;
    }



}
