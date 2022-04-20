package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations", schema ="hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "department_gen", sequenceName= "hr.locations_gen", allocationSize= 1)
public class Location implements Serializable {


    private static final long serialVersionUID = 5533925872032959772L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_gen")
    private Integer LOCATION_ID;
    private String STREET_ADDRESS;
    private String POSTAL_CODE;
    private String CITY;
    private String STATE_PROVINCE;
    private String COUNTRY_ID;



}
