package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.models.Location;
import com.example.test.repositories.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;
    public List<Location> getLocations(){

        return (List<Location>) locationRepo.findAll();
    }

    public Location createLocation(Location location) {
        return location;
    }

    public Location updateLocation(Integer LOCATION_ID, Location location) {
        return location;
    }

    public void deleteLocation(Integer LOCATION_ID) {}

    public Location getLocation(Integer LOCATION_ID) {
        return null;
    }
}
