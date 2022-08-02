package com.example.test.dto.request;

import com.example.test.validation.TitleValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
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

    @AssertTrue(message = "Enter valid job id")
    private boolean isValid() {
        if(jobTitle == null || jobId == null){
            return false;
        }
        String[] str = jobTitle.split("_");

        String expected = "";
        for (int i = 0; i < str.length; i++) {
            expected += str[i].charAt(0);
        }
        return jobId.startsWith(expected) ;
    }
}