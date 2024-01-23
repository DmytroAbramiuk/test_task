package com.example.test_task.customer.service;

import com.example.test_task.customer.data.entity.CustomerEntity;
import com.example.test_task.customer.data.repository.CustomerRepository;
import com.example.test_task.customer.exception.email.EmailContainsSpacesException;
import com.example.test_task.customer.exception.phone.PhoneContainsSpacesException;
import com.example.test_task.customer.exception.phone.StartsWithPhoneNumberException;
import com.example.test_task.customer.mapper.CustomerMapper;
import com.example.test_task.customer.response.CustomerResponse;
import com.example.test_task.customer.service.dto.CustomerDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.StaleObjectStateException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    @Override
    public List<CustomerDto> listAll() {
        return mapper.toCustomerDtos(customerRepository.findAll());
    }

    @Override
    @Transactional
    public CustomerDto create(CustomerDto customer) {
        if(!customer.getPhone().startsWith("+")){
            throw new StartsWithPhoneNumberException(customer.getPhone());
        }
        if(customer.getPhone().contains(" ")){
            throw new PhoneContainsSpacesException(customer.getPhone());
        }
        if(customer.getEmail().contains(" ")){
            throw new EmailContainsSpacesException(customer.getEmail());
        }
        CustomerEntity customerEntity = mapper.toCustomerEntity(customer);
        customerEntity.setId(null);
        customerEntity.setActive(true);
        return mapper.toCustomerDto(customerRepository.save(customerEntity));
    }

    @Override
    public CustomerDto getById(Long id) {
        return mapper.toCustomerDto(customerRepository.getReferenceById(id));
    }

    @Override
    @Transactional
    public CustomerDto update(CustomerDto customer) {
        Date date = new Date();
        if(!customer.getPhone().startsWith("+")){
            throw new StartsWithPhoneNumberException(customer.getPhone());
        }
        if(customer.getPhone().contains(" ")){
            throw new PhoneContainsSpacesException(customer.getPhone());
        }
        CustomerDto toUpdate = getById(customer.getId());
        customer.setUpdated(date.getTime());
        customer.setCreated(toUpdate.getCreated());
        customer.setActive(toUpdate.isActive());
        customer.setEmail(toUpdate.getEmail());
        customerRepository.save(mapper.toCustomerEntity(customer));
        return customer;
    }

    @Override
    public void delete(Long id){
        customerRepository.markInactive(id, false);
    }

}
