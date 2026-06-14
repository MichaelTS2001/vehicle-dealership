package com.example.vehicle_dealership.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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

    @NotBlank(message = "VIN is required")
    @Size(min = 5, max = 5, message = "VIN number must be 5 characters")
    @Column(nullable = false, length = 5)
    private String VIN;

    @NotBlank(message = "Vehicle year is required")
    @Size(min = 1000, max = 9999, message = "Vehicle year must be between 1000 and 9999 characters")
    @Column(nullable = false, length = 9999)
    private String year;

    @NotBlank(message = "Vehicle type is required")
    @Size(min = 1, max = 20, message = "Vehicle year must be between 1 and 20 characters")
    @Column(nullable = false, length = 20)
    private String vehicleModel;



}
