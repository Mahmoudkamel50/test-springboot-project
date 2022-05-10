package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "JOBS",schema = "HR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "MIN_SALARY")
    private BigDecimal minSalary;
    @Column(name = "MAX_SALARY")
    private BigDecimal maxSalary;
}
