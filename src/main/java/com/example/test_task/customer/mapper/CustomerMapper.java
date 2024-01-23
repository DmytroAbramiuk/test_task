package com.example.test_task.customer.mapper;

import com.example.test_task.customer.service.dto.CustomerDto;
import com.example.test_task.customer.response.CustomerResponse;
import com.example.test_task.customer.request.UpdateCustomerRequest;
import com.example.test_task.customer.data.entity.CustomerEntity;
import com.example.test_task.customer.request.CreateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    public List<CustomerDto> toCustomerDtos(Collection<CustomerEntity> entities){
        return entities.stream()
                .map(this::toCustomerDto)
                .collect(Collectors.toList());
    }

    public CustomerDto toCustomerDto(CustomerEntity entity){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getId());
        customerDto.setUpdated(entity.getUpdated());
        customerDto.setCreated(entity.getCreated());
        customerDto.setEmail(entity.getEmail());
        customerDto.setFullName(entity.getFullName());
        customerDto.setPhone(entity.getPhone());
        customerDto.setActive(entity.isActive());
        return customerDto;
    }

    public CustomerDto toCustomerDto(CreateCustomerRequest request){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(request.getEmail());
        customerDto.setFullName(request.getFullName());
        customerDto.setPhone(request.getPhone());
        return customerDto;
    }

    public CustomerDto toCustomerDto(Long id, UpdateCustomerRequest request){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(id);
        customerDto.setFullName(request.getFullName());
        customerDto.setPhone(request.getPhone());
        return customerDto;
    }

    public CustomerEntity toCustomerEntity(CustomerDto dto){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(dto.getId());
        customerEntity.setUpdated(dto.getUpdated());
        customerEntity.setCreated(dto.getCreated());
        customerEntity.setEmail(dto.getEmail());
        customerEntity.setFullName(dto.getFullName());
        customerEntity.setPhone(dto.getPhone());
        customerEntity.setActive(dto.isActive());
        return customerEntity;
    }

    public List<CustomerResponse> toCustomerResponses(Collection<CustomerDto> entities){
        return entities.stream()
                .map(this::toCustomerResponse)
                .collect(Collectors.toList());
    }

    public CustomerResponse toCustomerResponse(CustomerDto dto){
        CustomerResponse response = new CustomerResponse();
        response.setId(dto.getId());
        response.setFullName(dto.getFullName());
        response.setEmail(dto.getEmail());
        response.setPhone(dto.getPhone());
        return response;
    }
}
