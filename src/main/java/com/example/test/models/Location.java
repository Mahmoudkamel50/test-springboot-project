package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCATIONS",schema = "HR")
@SequenceGenerator(name = "locations_gen", sequenceName = "hr.locations_seq", allocationSize = 1)

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_gen")
    @Column(name = "LOCATION_ID")
    private Long locationId;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_PROVINCE")
    private String stateProvince;
    @Column(name = "COUNTRY_ID")
    private String countryId;
}
