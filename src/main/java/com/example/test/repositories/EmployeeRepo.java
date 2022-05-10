package com.example.test.repositories;

import com.example.test.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Employee findByEmployeeId(Long id);
    List<Employee> findByFirstName(String firstName);
}
