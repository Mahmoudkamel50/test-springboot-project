package com.example.test.repositories;

import com.example.test.models.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepo extends CrudRepository<Job, String> {
    Job findJobByJobId(String id);
    Job findByJobTitle(String jobTitle);
}
