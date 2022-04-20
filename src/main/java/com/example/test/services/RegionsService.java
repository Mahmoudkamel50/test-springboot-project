package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.models.Regions;
import com.example.test.repositories.RegionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegionsService {
    @Autowired
    private RegionsRepo regionsRepo;
    public List<Regions> getRegions(){

        return (List<Regions>) regionsRepo.findAll();
    }

    public Regions createRegions(Regions regions) {
        return regions;
    }

    public Regions updateRegions(Integer REGION_ID, Regions regions) {
        return regions;
    }

    public void deleteRegions(Integer REGION_ID) {}

    public Employee getRegion(Integer REGION_ID) {
        return null;
    }
}
