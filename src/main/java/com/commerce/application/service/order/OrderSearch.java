package com.commerce.application.service.order;

import com.commerce.application.model.entity.Order;

public interface OrderSearch {
    Order findOrderById(Integer id);
    Boolean orderExistsById(Integer id);
}
