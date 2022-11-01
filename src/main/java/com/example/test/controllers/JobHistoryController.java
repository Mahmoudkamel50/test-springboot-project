package com.example.test.controllers;

import com.example.test.models.JobHistory;
import com.example.test.services.JobHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jobHistory")
@RequiredArgsConstructor
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    @GetMapping
    public ResponseEntity<?> getJobHistories(){
        return new ResponseEntity<> (jobHistoryService.getJobHistories(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getJobHistory(@PathVariable Long employeeId){
        return new ResponseEntity<> (jobHistoryService.getJobHistory(employeeId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createJobHistory(@RequestBody JobHistory e){
        return new ResponseEntity<>(jobHistoryService.createJobHistory(e), HttpStatus.CREATED);
    }

    @PutMapping(path = "update/{employeeId}")
    public  ResponseEntity<?> updateJobHistory(@PathVariable Long employeeId, @RequestBody JobHistory e){
        return new ResponseEntity<> (jobHistoryService.updateJobHistory(employeeId,e), HttpStatus.OK);
    }

    @DeleteMapping(path = "{EMPLOYEE_ID}")
    public  ResponseEntity<?> deleteJobHistory(@PathVariable Long employeeId){
        jobHistoryService.deleteJobHistory( employeeId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
