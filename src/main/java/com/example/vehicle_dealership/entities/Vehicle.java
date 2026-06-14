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
    @Size(min = 1, max = 100, message = "Vehicle Make must be between 1 and 100 characters")
    @Column(nullable = false, length = 100) //this means the column cannot store a null value and vehicle make cannot be
                                            //anymore than 100 characters
    private String make;

    @NotBlank(message = "Vehicle Model is required")
    @Size(min = 1, max = 100, message = "Vehicle Make must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String model;

    @NotBlank(message = "VIN is required")
    @Size(min = 1, max = 5, message = "VIN number must be between 1 and 5 characters")
    @Column(nullable = false, length = 5)
    private String VIN;

    @NotBlank(message = "Vehicle year is required")
    @Size(min = 1, max = 4, message = "Vehicle year must be between 1 and 4 characters")
    @Column(nullable = false, length = 4)
    private String year;

    @NotBlank(message = "Vehicle type is required")
    @Size(min = 1, max = 100, message = "Vehicle year must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String vehicleModel;



}
