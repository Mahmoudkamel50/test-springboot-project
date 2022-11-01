package com.example.test.dto.projection;

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentManager {
    @Value("#{target.MANAGER_ID}")
    String getManagerId();
}
