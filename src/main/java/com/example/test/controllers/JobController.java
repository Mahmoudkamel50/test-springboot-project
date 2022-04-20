package com.example.test.controllers;

import com.example.test.models.Job;
import com.example.test.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
        public ResponseEntity<?> getJobs(){
            return new ResponseEntity<> (jobService.getJobs(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getJob(String JOB_ID){
        return new ResponseEntity<> (jobService.getJob(JOB_ID), HttpStatus.OK);
    }

    @PostMapping("{/JOB_ID}")
    public ResponseEntity<?> createJob(Job job){
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED) ;
    }

    @PutMapping("/{JOB_ID}")
    public ResponseEntity<?> updateJob(@PathVariable String JOB_ID,@RequestBody Job job){
        return new ResponseEntity<>(JobService.updateJob(JOB_ID, job), HttpStatus.OK);
    }

    @DeleteMapping ("/{JOB_ID}")
    public ResponseEntity<?> deleteJob (@PathVariable String JOB_ID){
        jobService.deleteJob(JOB_ID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
