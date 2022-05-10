package com.example.test.repositories;

import com.example.test.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
    Department findByDepartmentId(Long id);
    void deleteByDepartmentId(Long id);
}
