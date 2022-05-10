package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.models.JobHistory;
import com.example.test.repositories.JobHistoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobHistoryService {
    @Autowired
    private JobHistoryRepo jobHistoryRepo;

    public Iterable<JobHistory> getJobHistories() {
        return jobHistoryRepo.findAll();
    }

    public JobHistory createJobHistory(JobHistory e) {

        jobHistoryRepo.save(e);
        return e;
    }

    public JobHistory updateJobHistory(Long empId, JobHistory e) {

        JobHistory jobHistory= jobHistoryRepo.findByEmployeeId(empId);
        if (jobHistory== null){
            return null;
        }
        jobHistory.setDepartmentId(e.getDepartmentId());
        jobHistory.setEmployeeId(e.getEmployeeId());
        jobHistory.setEndDate(e.getEndDate());
        jobHistory.setStartDate(e.getStartDate());
        jobHistoryRepo.save(jobHistory);
        return jobHistory;
    }

    public void deleteJobHistory(Long empId) {
        jobHistoryRepo.findByEmployeeId(empId);
    }

    public JobHistory getJobHistory(Long empId) {
        return jobHistoryRepo.findByEmployeeId(empId);
    }
}
