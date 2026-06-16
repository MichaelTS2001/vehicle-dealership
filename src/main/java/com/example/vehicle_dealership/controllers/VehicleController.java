package com.example.vehicle_dealership.controllers;

import com.example.vehicle_dealership.entities.Vehicle;
import com.example.vehicle_dealership.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    //GET -> /api/vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(
            @RequestParam(value = "vin", required = false) String vin
    ){
        if(vin == null){
            List<Vehicle> vehicles = this.vehicleService.getAllVehicles();
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
        else{
            List<Vehicle> vehicles = this.vehicleService.searchVehicles(vin);
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id){
        Optional<Vehicle> vehicle = this.vehicleService.getVehicleId(id);

        //Either there is a vehicle with this id, or there isn't
        if(vehicle.isPresent()){
            return new ResponseEntity<>(vehicle.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id){
        boolean deleteSuccessful = this.vehicleService.delete(id);

        if(!deleteSuccessful){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            //Successfully deletes return 204 (NOT CONTENT), not 200
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //A 400 Bad Request should be returned if the data is messed up
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody @Valid Vehicle vehicle){
        Vehicle newVehicle = this.vehicleService.create(vehicle);

        //Successfully creating data is a 201
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody @Valid Vehicle vehicle,
                                                 @PathVariable Long id){
        Vehicle updatedVehicle = this.vehicleService.update(id, vehicle);

        if(updatedVehicle == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        }
    }

}
