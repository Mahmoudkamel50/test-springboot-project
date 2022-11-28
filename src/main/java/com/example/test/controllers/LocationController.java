package com.example.test.controllers;

import com.example.test.models.Location;
import com.example.test.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<?> getLocations(){
        return new ResponseEntity<>(locationService.getLocations(), HttpStatus.OK);
    }
    @GetMapping(path = "{locationId}")
    public ResponseEntity<?> getLocation(@PathVariable Long locationId){
        return new ResponseEntity<>(locationService.getLocation(locationId), HttpStatus.OK);
    }

    @PostMapping
    public   ResponseEntity<?> createLocation( @RequestBody Location e){
        return new ResponseEntity<> (locationService.createLocation(e) , HttpStatus.CREATED);
    }

    @PutMapping(path = "update/{locationId}")
    public  ResponseEntity<?> updateLocation (@PathVariable Long locationId, @RequestBody Location e){
        return new ResponseEntity<>(locationService.updateLocation(locationId,e), HttpStatus.OK) ;
    }

    @DeleteMapping(path = "delete/{locationId}")
    public   ResponseEntity<?> deleteLocation (@PathVariable Long locationId){
        locationService.deleteLocation(locationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
