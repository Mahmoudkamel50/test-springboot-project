package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "jobHistory", schema ="hr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobHistory implements Serializable {

    private static final long serialVersionUID = 2521536430892150559L;
    @Id
    private Integer EMPLOYEE_ID;
    private Date START_DATE;
    private Date END_DATE;
    private String JOB_ID;
    private Integer DEPARTMENT_ID;

}
