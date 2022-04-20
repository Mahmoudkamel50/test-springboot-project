package com.example.test.controllers;

import com.example.test.models.JobHistory;
import com.example.test.services.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobHistory")
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    @GetMapping
    public ResponseEntity<?> getJobHistories(){
        return new ResponseEntity<> (jobHistoryService.getJobHistories(), HttpStatus.OK);
    }

    @GetMapping("{/EMPLOYEE_ID}")
    public ResponseEntity<?> getJobHistory(Integer EMPLOYEE_ID){
        return new ResponseEntity<> (jobHistoryService.getJobHistory(EMPLOYEE_ID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createJobHistory(@RequestBody JobHistory e){
        return new ResponseEntity<>(jobHistoryService.createJobHistory(e), HttpStatus.CREATED);
    }

    @PutMapping("/{EMPLOYEE_ID}")
    public  ResponseEntity<?> updateJobHistory(@PathVariable Integer EMPLOYEE_ID, @RequestBody JobHistory e){
        return new ResponseEntity<> (jobHistoryService.updateJobHistory(EMPLOYEE_ID,e), HttpStatus.OK);
    }

    @DeleteMapping("/{EMPLOYEE_ID}")
    public  ResponseEntity<?> deleteJobHistory(@PathVariable Integer EMPLOYEE_ID){
        jobHistoryService.deleteJobHistory( EMPLOYEE_ID);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
