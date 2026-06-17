package com.example.vehicle_dealership.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    //Always start with the entity
    //This tells how the table will be organized

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Validation
    @NotBlank(message = "Vehicle Make is required")
    @Size(min = 1, max = 50, message = "Vehicle Make must be between 1 and 100 characters")
    @Column(nullable = false, length = 50) //this means the column cannot store a null value and vehicle make cannot be
                                            //anymore than 100 characters
    private String make;

    @NotBlank(message = "Vehicle Model is required")
    @Size(min = 1, max = 50, message = "Vehicle Make must be between 1 and 50 characters")
    @Column(nullable = false, length = 50)
    private String model;

    @NotBlank(message = "Vin is required")
    @Size(min = 5, max = 5, message = "VIN number must be 5 characters")
    @Column(nullable = false, length = 5)
    private String vin;

    @NotBlank(message = "Vehicle year is required")
    @Size(min = 4, max = 4, message = "Vehicle year must be 4 characters")
    @Column(nullable = false, length = 4)
    private String year;

    @NotBlank(message = "Vehicle type is required")
    @Size(min = 1, max = 20, message = "Vehicle type must be between 1 and 20 characters")
    @Column(nullable = false, length = 20)
    private String vehicleType;

    @NotBlank(message = "Vehicle color is required")
    @Size(min = 1, max = 20, message = "Vehicle color must be between 1 and 20 characters")
    @Column(nullable = false, length = 20)
    private String vehicleColor;

    @Positive(message = "Vehicle odometer cannot be negative")
    @Column(nullable = false, length = 10)
    private Double vehicleOdometer;

    @DecimalMin(value = "0", message = "Vehicle price cannot be negative")
    @Column(nullable = false, length = 10)
    private Double vehiclePrice;

    public Vehicle(Long id, String make, String model, String vin, String year, String vehicleType, String vehicleColor,
                   Double vehicleOdometer, Double vehiclePrice) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.year = year;
        this.vehicleType = vehicleType;
        this.vehicleColor = vehicleColor;
        this.vehicleOdometer = vehicleOdometer;
        this.vehiclePrice = vehiclePrice;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Double getVehicleOdometer() {
        return vehicleOdometer;
    }

    public void setVehicleOdometer(Double vehicleOdometer) {
        this.vehicleOdometer = vehicleOdometer;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
}
