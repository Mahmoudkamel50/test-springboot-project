package com.example.test.controllers;

import com.example.test.models.Location;
import com.example.test.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<?> getLocations(){
        return new ResponseEntity<>(locationService.getLocations(), HttpStatus.OK);
    }
    @GetMapping("/{LOCATION_ID}")
    public ResponseEntity<?> getLocation(Integer LOCATION_ID){
        return new ResponseEntity<>(locationService.getLocation(LOCATION_ID), HttpStatus.OK);
    }

    @PostMapping
    public   ResponseEntity<?> createLocation( @RequestBody Location e){
        return new ResponseEntity<> (locationService.createLocation(e) , HttpStatus.CREATED);
    }

    @PutMapping("/{LOCATION_ID}")
    public  ResponseEntity<?> updateLocation (@PathVariable Integer LOCATION_ID, @RequestBody Location e){
        return new ResponseEntity<>(locationService.updateLocation(LOCATION_ID,e), HttpStatus.OK) ;
    }

    @DeleteMapping("/{LOCATION_ID}")
    public   ResponseEntity<?> deleteLocation (@PathVariable Integer LOCATION_ID){
        locationService.deleteLocation(LOCATION_ID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
