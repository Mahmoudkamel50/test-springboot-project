package com.example.test.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employees", schema ="hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "employee_gen", sequenceName= "hr.employees_seq", allocationSize= 1)
public class Employee implements Serializable {

    private static final long serialVersionUID = 8231148457786541960L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_gen")
    private Integer EMPLOYEE_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String PHONE_NUMBER;
    private String EMAIL;
    private Date HIRE_DATE;
    private String JOB_ID;
    private Integer SALARY;
    private Integer COMMISSION_PCT;
    private Integer MANAGER_ID;
    private Integer DEPARTMENT_ID;


}
