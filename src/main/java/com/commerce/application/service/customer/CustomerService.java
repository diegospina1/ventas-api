package com.commerce.application.service.customer;

import com.commerce.application.dto.customer.CreateCustomerDto;
import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.customer.UpdateCustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> listAllCustomers();

    CustomerDto listOneCustomer(String document);

    CustomerDto createCustomer(CreateCustomerDto customerDto);

    CustomerDto updateCustomer(UpdateCustomerDto customerDto);

    void deleteCustomer(Integer id);
}
