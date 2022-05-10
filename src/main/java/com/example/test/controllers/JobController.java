package com.example.test.controllers;

import com.example.test.models.Job;
import com.example.test.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<?> getJobs() {
        return new ResponseEntity<>(jobService.getJobs(), HttpStatus.OK);
    }

    @GetMapping(path = "{jobId}")
    public ResponseEntity<?> getJob(@PathVariable String jobId) {
        return new ResponseEntity<>(jobService.getJob(jobId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createJob(Job job) {
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{jobId}")
    public ResponseEntity<?> updateJob(@PathVariable String jobId, @RequestBody Job job) {
        return new ResponseEntity<>(jobService.updateJob(jobId, job), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable String jobId) {
        jobService.deleteJob(jobId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
