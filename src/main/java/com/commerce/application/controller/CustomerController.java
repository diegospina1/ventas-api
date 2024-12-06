package com.commerce.application.controller;

import com.commerce.application.dto.customer.CustomerDto;
import com.commerce.application.dto.customer.CreateCustomerDto;
import com.commerce.application.dto.customer.UpdateCustomerDto;
import com.commerce.application.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listAllCustomers(){
        return ResponseEntity.ok(customerService.listAllCustomers());
    }

    @GetMapping("/{document}")
    public ResponseEntity<CustomerDto> listOneCustomer(@PathVariable("document") String document){
        return ResponseEntity.ok(customerService.listOneCustomer(document));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CreateCustomerDto customerDto){
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody @Valid UpdateCustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateCustomer(customerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
