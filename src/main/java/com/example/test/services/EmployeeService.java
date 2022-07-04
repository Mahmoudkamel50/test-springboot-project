package com.example.test.services;

import com.example.test.models.Employee;
import com.example.test.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getEmployees() {
        return ( List<Employee>)employeeRepo.findAll();
    }

    public Employee getEmployee(Long empId) {
        return employeeRepo.findByEmployeeId(empId);
    }

    public Employee createEmployees(Employee employee) {

        employeeRepo.save(employee);
        return employee;
    }

    public Employee updateEmployees(Long empId, Employee employee) {

        Employee emp = employeeRepo.findByEmployeeId(empId);
        if(emp == null){
            return null ;
        }
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setPhoneNumber(employee.getPhoneNumber());
        emp.setEmail(employee.getEmail());
        emp.setHireDate(employee.getHireDate());
        emp.setJobId(employee.getJobId());
        emp.setSalary(employee.getSalary());
        emp.setCommissionPct(employee.getCommissionPct());
        emp.setManagerId(employee.getManagerId());
        emp.setDepartmentId(employee.getDepartmentId());
        employeeRepo.save(emp);
        return emp;
    }

    public void deleteEmployees(Long empId) {
        employeeRepo.deleteById(empId);
    }

}
