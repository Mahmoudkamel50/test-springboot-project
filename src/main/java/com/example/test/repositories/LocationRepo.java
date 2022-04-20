package com.example.test.repositories;

import com.example.test.models.Location;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface LocationRepo extends CrudRepository<Location, Serializable> {

}
