package com.example.test.controllers;


import com.example.test.models.Employee;
import com.example.test.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path ="{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable Long employeeId){
        if (employeeId < 1){
            return new ResponseEntity<>("enter valid number", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getEmployees() {

        return new ResponseEntity<>( employeeService.getEmployees(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEmployees(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployees(employee), HttpStatus.CREATED);
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
