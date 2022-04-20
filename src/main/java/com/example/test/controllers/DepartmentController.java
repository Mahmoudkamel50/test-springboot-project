package com.example.test.controllers;

import com.example.test.models.Department;
import com.example.test.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }
    @GetMapping("{/DEPARTMENT_ID}")
    public ResponseEntity<?> getDepartment(Integer DEPARTMENT_ID){
        return new ResponseEntity<>(departmentService.getDepartment(DEPARTMENT_ID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        return new ResponseEntity<> (departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @PutMapping("/{DEPARTMENT_ID}")
    public  ResponseEntity<?> updateDepartment(@PathVariable Integer DEPARTMENT_ID, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartment(DEPARTMENT_ID,department), HttpStatus.OK);
    }

    @DeleteMapping("/{DEPARTMENT_ID}")
    public  ResponseEntity<?> deleteDepartment(@PathVariable Integer DEPARTMENT_ID){
        departmentService.deleteDepartment(DEPARTMENT_ID);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
