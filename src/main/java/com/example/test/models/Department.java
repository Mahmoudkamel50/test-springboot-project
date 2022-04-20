package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "departments", schema ="hr")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "department_gen", sequenceName= "hr.departments_gen", allocationSize= 1)
public class Department implements Serializable {
    private static final long serialVersionUID = -7181771928201878793L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_gen")
    private Integer DEPARTMENT_ID;
    private String DEPARTMENT_NAME;
    private Integer MANAGER_ID;
    private Integer LOCATION_ID;

}
