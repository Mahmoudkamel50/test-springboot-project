package com.example.test.services;

import com.example.test.models.Job;
import com.example.test.repositories.JobHistoryRepo;
import com.example.test.repositories.JobRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private JobRepo jobRepo;

    public List<Job> getJobs(){
         return (List<Job>) jobRepo.findAll();
    }

    public static Job updateJob(String JOB_ID, Job job) {
        return job;
    }

    public Job createJob(Job job){
        return job ;
    };



    public void deleteJob(String JOB_ID) {}

    public Job getJob(String job_id) {
        return null;
    }
}
