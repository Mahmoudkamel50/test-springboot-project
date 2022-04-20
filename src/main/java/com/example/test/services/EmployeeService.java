package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    public List<Employee> getEmployees(){

        return  employeeRepo.findAll();
    }

    public Employee createEmployees(Employee employee) {
        return employee;
    }

    public Employee updateEmployees(Integer EMPLOYEE_ID, Employee employee) {
        return employee;
    }

    public void deleteEmployees(Integer EMPLOYEE_ID) {}

    public Employee getEmployee(Integer EMPLOYEE_ID) {
        return null;
    }
}
