package com.example.test.repositories;

import com.example.test.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job, String> {

}
