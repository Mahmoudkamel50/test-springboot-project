package com.example.test.repositories;

import com.example.test.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Serializable> {
    Employee findByEMPLOYEE_ID(Integer EMPLOYEE_ID);

    List<Employee> findByFIRST_NAME(String FIRST_NAME);

    void deleteByEMPLOYEE_ID(Integer EMPLOYEE_ID);

    default List<Employee> findAll() {
        return null;
    }

}
