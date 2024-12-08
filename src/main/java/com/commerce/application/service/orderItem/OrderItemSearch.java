package com.commerce.application.service.orderItem;

import com.commerce.application.model.entity.OrderItem;

public interface OrderItemSearch {

    OrderItem findById(Integer id);
    Boolean existsById(Integer id);
}
