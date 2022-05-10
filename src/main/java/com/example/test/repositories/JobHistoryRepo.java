package com.example.test.repositories;

import com.example.test.models.JobHistory;
import org.springframework.data.repository.CrudRepository;

public interface JobHistoryRepo extends CrudRepository<JobHistory, Long> {
    JobHistory findByEmployeeId(Long id);
}
