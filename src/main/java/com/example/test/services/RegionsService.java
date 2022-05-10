package com.example.test.services;

import com.example.test.models.Region;
import com.example.test.repositories.RegionsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionsService {

    @Autowired
    private RegionsRepo regionsRepo;

    public List<Region> getRegions() {

        return (List<Region>) regionsRepo.findAll();
    }

    public Region createRegions(Region region) {

        regionsRepo.save(region);
        return region;
    }

    public Region updateRegions(Long regionId, Region region) {

        Region region1= regionsRepo.findByRegionId(regionId);
        if (region1 == null){
            return null;
        }
        region1.setRegionName(region.getRegionName());
        regionsRepo.save(region1);
        return region1;
    }

    public void deleteRegions(Long regionId) {
        regionsRepo.deleteById(regionId);
    }

    public Region getRegion(Long regionId) {
        return regionsRepo.findByRegionId(regionId);
    }
}
