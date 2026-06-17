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
    ){
        List<Vehicle> vehicles = this.vehicleService.getAllVehicles();
        if(vehicles.isEmpty()){
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
    }

    //GET -> /api/{id}
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
    
    //GET -> /api/vehicles/find-color?color=red
    @GetMapping("/find-color")
    public ResponseEntity<List<Vehicle>> searchByColor(
            @RequestParam(value = "color", required = true) String vehicleColor){
        
        List<Vehicle> vehicles = this.vehicleService.searchByColor(vehicleColor);
        
        if(vehicles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
    }

    //GET -> /api/vehicles/find-vin?vin=?????
    @GetMapping("/find-vin")
    public ResponseEntity<List<Vehicle>> searchByVin(
            @RequestParam(value = "vin", required = true) String vin) {

        List<Vehicle> vehicles = this.vehicleService.searchByVin(vin);

        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        }
    }

    //GET -> /api/vehicles/find-make?make=?????
    @GetMapping("/find-make")
    public ResponseEntity<List<Vehicle>> searchByMake(
            @RequestParam(value = "make", required = true) String make) {

        List<Vehicle> vehicles = this.vehicleService.searchByMake(make);

        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
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
