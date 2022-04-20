package com.example.test.repositories;

import com.example.test.models.Department;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface DepartmentRepo extends CrudRepository<Department, Serializable> {

    List<Department> findAllBy();
}
