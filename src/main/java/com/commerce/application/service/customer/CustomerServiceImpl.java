package com.commerce.application.service.customer;

import com.commerce.application.dto.customer.CreateCustomerDto;
import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.customer.UpdateCustomerDto;
import com.commerce.application.model.entity.Customer;
import com.commerce.application.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import static com.commerce.application.mapper.CustomerMapper.customerMapper;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CustomerDto> listAllCustomers() {
        return repository.findAll().stream()
                .map(customerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto listOneCustomer(String document) {
        var customer = repository.findByDocument(document)
                .orElseThrow(EntityNotFoundException::new);
        return customerMapper.toCustomerDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CreateCustomerDto customerDto) {
        Customer customer = new Customer(customerDto);
        return customerMapper.toCustomerDto(repository.save(customer));
    }

    @Override
    public CustomerDto updateCustomer(UpdateCustomerDto customerDto) {
        Customer customer = repository.findByDocument(customerDto.document())
                .orElseThrow(EntityNotFoundException::new);

        customer.actualizar(customerDto);
        return customerMapper.toCustomerDto(repository.save(customer));
    }

    @Override
    public void deleteCustomer(Integer id) {

    }

    @Override
    public Customer findCustomerById(Integer id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Boolean customerExistsById(Integer id) {
        return repository.existsById(id);
    }
}
