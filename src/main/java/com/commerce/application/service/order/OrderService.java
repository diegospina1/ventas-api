package com.commerce.application.service.order;

import com.commerce.application.dto.order.CreateOrderDto;
import com.commerce.application.dto.order.OrderDto;
import com.commerce.application.dto.order.UpdateOrderDto;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderService extends OrderSearch{
    List<OrderDto> listAllOrdersByCustomerId(Integer id);

    OrderDto listOneOrder(Integer id);

    OrderDto createOrder(@Valid CreateOrderDto orderDto);

    OrderDto updateOrder(@Valid UpdateOrderDto orderDto);

    void deleteOrder(Integer id);
}
