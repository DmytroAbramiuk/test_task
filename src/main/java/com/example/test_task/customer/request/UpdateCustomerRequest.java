package com.example.test_task.customer.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    @Size(min = 2, max = 50, message = "The full name length must be between 2 and 50 characters.")
    private String fullName;
    @NotBlank(message = "phone number shouldn't have any whitespaces!")
    @Size(min = 6, max = 14, message = "The email length must be between 2 and 100 characters.")
    private String phone;
}
