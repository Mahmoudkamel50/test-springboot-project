package com.example.test.repositories;

import com.example.test.models.JobHistory;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface JobHistoryRepo extends CrudRepository<JobHistory, Serializable> {
}
