package com.example.test.services;

import com.example.test.dto.request.EmployeeRequest;
import com.example.test.models.Employee;
import com.example.test.models.Job;
import com.example.test.repositories.EmployeeRepo;
import com.example.test.repositories.JobRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private JobService jobService;

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

    public Employee createEmployeeWithJob(EmployeeRequest employeeRequest) {

        if(jobService.getJobByTitle(employeeRequest.getJobTitle()) != null){
            Employee employee= new Employee();

            employee.setFirstName(employeeRequest.getFirstName());
            employee.setLastName(employeeRequest.getLastName());
            employee.setEmail(employeeRequest.getEmail());
            employee.setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.setJobId(employeeRequest.getJobId());
            employee.setSalary(employeeRequest.getSalary());
            employee.setCommissionPct(employeeRequest.getCommissionPct());
            employee.setManagerId(employeeRequest.getManagerId());
            employee.setDepartmentId(employeeRequest.getDepartmentId());
            employee.setHireDate(new Date());
            employeeRepo.save(employee);
            return employee;
        }
        else{
            Job job= new Job();
            job.setJobId(employeeRequest.getJobId());
            job.setJobTitle(employeeRequest.getJobTitle());

            jobRepo.save(job);


            Employee employee = new Employee();

            employee.setFirstName(employeeRequest.getFirstName());
            employee.setLastName(employeeRequest.getLastName());
            employee.setEmail(employeeRequest.getEmail());
            employee.setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.setJobId(employeeRequest.getJobId());
            employee.setSalary(employeeRequest.getSalary());
            employee.setCommissionPct(employeeRequest.getCommissionPct());
            employee.setManagerId(employeeRequest.getManagerId());
            employee.setDepartmentId(employeeRequest.getDepartmentId());
            employee.setHireDate(new Date());
            employeeRepo.save(employee);
            return employee;
        }
    }
}
