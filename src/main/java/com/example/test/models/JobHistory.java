package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JOB_HISTORY",schema = "HR")
public class JobHistory{
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;
}
