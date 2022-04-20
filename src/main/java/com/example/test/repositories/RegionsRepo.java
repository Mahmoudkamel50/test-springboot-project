package com.example.test.repositories;

import com.example.test.models.Regions;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface RegionsRepo extends CrudRepository<Regions, Serializable> {

}
