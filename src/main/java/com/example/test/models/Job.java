package com.example.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "jobs", schema ="hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job implements Serializable {

    private static final long serialVersionUID = 6875389038299438806L;

    @Id
    private String JOB_ID;
    private String JOB_TITLE;
    private Integer MIN_SALARY;
    private Integer MAX_SALARY;

}
