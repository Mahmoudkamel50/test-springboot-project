package com.example.test.repositories;

import com.example.test.models.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionsRepo extends CrudRepository<Region, Long> {
    Region findByRegionId(Long id);
}
