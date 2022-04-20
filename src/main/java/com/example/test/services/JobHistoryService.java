package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.models.JobHistory;
import com.example.test.repositories.JobHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobHistoryService {
    @Autowired
    private JobHistoryRepo jobHistoryRepo;

    public Iterable<JobHistory> getJobHistories() {
        return jobHistoryRepo.findAll();
    }

    public JobHistory createJobHistory(JobHistory e) {
        return e;
    }

    public JobHistory updateJobHistory(Integer EMPLOYEE_ID, JobHistory e) {
        return e;
    }

    public void deleteJobHistory(Integer EMPLOYEE_ID) {}

    public JobHistory getJobHistory(Integer EMPLOYEE_ID) {
        return null;
    }
}
