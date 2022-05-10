package com.example.test.repositories;

import com.example.test.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepo extends CrudRepository<Location, Long> {
    Location findByLocationId(Long id);

}
