package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.models.Location;
import com.example.test.repositories.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public List<Location> getLocations() {

        return (List<Location>) locationRepo.findAll();
    }

    public Location createLocation(Location location) {

        locationRepo.save(location);
        return location;
    }

    public Location updateLocation(Long locationId, Location location) {
        Location location1 =locationRepo.findByLocationId(locationId);
        if (location1== null){
            return null;
        }
        location1.setCity(location.getCity());
        location1.setCountryId(location.getCountryId());
        location1.setPostalCode(location.getPostalCode());
        location1.setStateProvince(location.getStateProvince());
        location1.setStreetAddress(location.getStreetAddress());
        locationRepo.save(location1);
        return location1;
    }

    public void deleteLocation(Long locationId) {
        locationRepo.deleteById(locationId);
    }

    public Location getLocation(Long locationId) {
        return locationRepo.findByLocationId(locationId);
    }
}
