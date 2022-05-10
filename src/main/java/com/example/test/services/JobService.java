package com.example.test.services;

import com.example.test.models.Job;
import com.example.test.repositories.JobHistoryRepo;
import com.example.test.repositories.JobRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public List<Job> getJobs() {
        return (List<Job>) jobRepo.findAll();
    }

    public  Job updateJob(String jobId, Job job) {
        Job job1 =jobRepo.findJobByJobId(jobId);
        if (job1== null){
            return null;
        }
        job1.setJobTitle(job.getJobTitle());
        job1.setMaxSalary(job.getMaxSalary());
        job1.setMinSalary(job.getMinSalary());
        jobRepo.save(job1);
        return job1;
    }

    public Job createJob(Job job) {
        jobRepo.save(job);
        return job;
    }

    public void deleteJob(String jobId) {
        jobRepo.deleteById(jobId);
    }

    public Job getJob(String jobId) {
        return jobRepo.findJobByJobId(jobId);
    }
}
