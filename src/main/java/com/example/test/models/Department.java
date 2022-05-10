package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENTS",schema = "HR")
@SequenceGenerator(name = "departments_gen", sequenceName = "hr.departments_seq", allocationSize = 1)

public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "departments_gen")
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    @Column(name = "MANAGER_ID")
    private Long managerId;
    @Column(name = "LOCATION_ID")
    private Long locationId;

}
