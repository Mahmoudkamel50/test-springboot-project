package com.example.test.services;

import com.example.test.models.Department;
import com.example.test.models.Employee;
import com.example.test.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;


    public List<Department> getDepartments(){

        return (List<Department>) departmentRepo.findAll();
    }

    public Department createDepartment(Department department) {
        return department;
    }

    public Department updateDepartment(Integer DEPARTMENT_ID, Department department) {
        return department;
    }

    public void deleteDepartment(Integer DEPARTMENT_ID) {}

    public Department getDepartment(Integer DEPARTMENT_ID) {
        return null;
    }


    }

