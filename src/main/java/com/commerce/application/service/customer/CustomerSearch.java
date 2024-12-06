package com.commerce.application.service.customer;

import com.commerce.application.model.entity.Customer;

public interface CustomerSearch {

    Customer findCustomerById(Integer id);
    Boolean CustomerExistsById(Integer id);
}
