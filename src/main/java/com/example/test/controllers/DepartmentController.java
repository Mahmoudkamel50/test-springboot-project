package com.example.test.controllers;

import com.example.test.models.Department;
import com.example.test.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private  DepartmentService departmentService;

    @GetMapping(path = "{departmentName}")
    public ResponseEntity<?> getManagerIdByName(@PathVariable String departmentName){
        return new ResponseEntity<>(departmentService.getManagerId(departmentName), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }
    @GetMapping(path = "{departmentId}")
    public ResponseEntity<?> getDepartment(@PathVariable Long departmentId){
        return new ResponseEntity<>(departmentService.getDepartment(departmentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        return new ResponseEntity<> (departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @PutMapping(path = "update/{departmentId}")
    public  ResponseEntity<?> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartment(departmentId,department), HttpStatus.OK);
    }
    @DeleteMapping(path = "delete/{departmentId}")
    public  ResponseEntity<?> deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
