package com.example.test_task.customer.service;

import com.example.test_task.customer.response.CustomerResponse;
import com.example.test_task.customer.service.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> listAll();
    CustomerDto create(CustomerDto customer);
    CustomerDto getById(Long id);
    CustomerDto update(CustomerDto customer);
    void delete(Long id);
}
