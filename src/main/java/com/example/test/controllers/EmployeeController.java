package com.example.test.controllers;


import com.example.test.dto.request.EmployeeRequest;
import com.example.test.models.Employee;
import com.example.test.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping(path ="{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable @Min(value = 1, message = "enter valid number") Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getEmployees() {

        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEmployees(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployees(employee), HttpStatus.CREATED);
    }

    @PostMapping(path = "/employee-job")
    public ResponseEntity<?> createEmployeeWithJob(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return new ResponseEntity<>(employeeService.createEmployeeWithJob(employeeRequest), HttpStatus.CREATED);
    }

    @PutMapping(path ="{employeeId}")
    public ResponseEntity<?> updateEmployees(@PathVariable Long employeeId, @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployees(employeeId, employee), HttpStatus.OK);
    }

    @DeleteMapping(path ="{employeeId}")
    public ResponseEntity<?> deleteEmployees(@PathVariable Long employeeId) {
        employeeService.deleteEmployees(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
