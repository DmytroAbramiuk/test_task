package com.example.test_task.customer.controller;

import com.example.test_task.customer.mapper.CustomerMapper;
import com.example.test_task.customer.request.CreateCustomerRequest;
import com.example.test_task.customer.request.UpdateCustomerRequest;
import com.example.test_task.customer.response.CustomerResponse;
import com.example.test_task.customer.service.dto.CustomerDto;
import com.example.test_task.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> customerList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerMapper.toCustomerResponses(customerService.listAll()));
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerMapper.toCustomerResponse(customerService.getById(id)));
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request){
        CustomerDto customerDto = customerMapper.toCustomerDto(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerMapper.toCustomerResponse(customerService.create(customerDto)));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id,
                                                      @RequestBody UpdateCustomerRequest request){
        CustomerDto customerDto = customerMapper.toCustomerDto(id, request);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(customerMapper.toCustomerResponse(customerService.update(customerDto)));
    }

    @DeleteMapping("/customers/{id}")
    public void updateCustomer(@PathVariable("id") Long id){
        customerService.delete(id);
    }
}
