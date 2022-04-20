package com.example.test.controllers;


import com.example.test.models.Employee;
import com.example.test.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/ {EMPLOYEE_ID}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer EMPLOYEE_ID){

        return new ResponseEntity<> (employeeService.getEmployee(EMPLOYEE_ID), HttpStatus.OK );
    }

    @GetMapping
    public ResponseEntity<?> getEmployees(){

        return new ResponseEntity<> ( employeeService.getEmployees(), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<?> createEmployees(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployees(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{EMPLOYEE_ID}")
    public  ResponseEntity<?> updateEmployees(@PathVariable Integer EMPLOYEE_ID, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployees (EMPLOYEE_ID ,employee), HttpStatus.OK);
    }

    @DeleteMapping("/{EMPLOYEE_ID}")
    public  ResponseEntity<?> deleteEmployees(@PathVariable Integer EMPLOYEE_ID){
        employeeService.deleteEmployees(EMPLOYEE_ID);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
