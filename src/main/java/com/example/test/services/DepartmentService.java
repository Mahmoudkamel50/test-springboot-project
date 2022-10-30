package com.example.test.services;

import com.example.test.dto.projection.DepartmentManager;
import com.example.test.models.Department;
import com.example.test.repositories.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;


    public List<Department> getDepartments(){

        return (List<Department>) departmentRepo.findAll();
    }

    public Department createDepartment(Department department) {

        departmentRepo.save(department);
        return department;
    }

    public Department updateDepartment(Long depId, Department department) {

        Department department1= departmentRepo.findByDepartmentId(depId);

        if (department1 == null){
            return null;
        }
        department1.setDepartmentName(department.getDepartmentName());
        department1.setManagerId(department.getManagerId());
        department1.setLocationId(department.getLocationId());
        departmentRepo.save(department1);
        return department1;
    }

    public void deleteDepartment(Long depId) {
        departmentRepo.deleteByDepartmentId(depId);
    }

    public Department getDepartment(Long depId) {

        return departmentRepo.findByDepartmentId(depId);
    }

    public List<Long> getManagerId(String departmentName) {
        return departmentRepo.queryManagerIdByDepartmentNameQuery(departmentName);
    }
}

