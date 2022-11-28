package com.example.test.repositories;

import com.example.test.dto.projection.DepartmentManager;
import com.example.test.models.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
    Department findByDepartmentId(Long id);
    void deleteByDepartmentId(Long id);
    @Query(nativeQuery = true, value = "SELECT MANAGER_ID FROM hr.DEPARTMENTS WHERE department_name = :departmentName")
    DepartmentManager queryManagerIdByDepartmentNameQuery(String departmentName);
}
