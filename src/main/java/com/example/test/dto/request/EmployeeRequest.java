package com.example.test.dto.request;

import com.example.test.validation.TitleValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest implements Serializable {
    private static final long serialVersionUID = -6279840942665944306L;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String jobId;
    private Integer salary;
    private double commissionPct;
    private Long managerId;
    private Long departmentId;
    @TitleValidation
    private String jobTitle;
}