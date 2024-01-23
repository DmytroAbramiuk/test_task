package com.example.test_task.customer.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Long created;
    private Long updated;
    private boolean isActive;
}
