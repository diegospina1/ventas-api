package com.commerce.application.service.orderItem;

import com.commerce.application.dto.orderItem.CreateOrderItemDto;
import com.commerce.application.dto.orderItem.OrderItemDto;
import com.commerce.application.dto.orderItem.UpdateOrderItemDto;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDto> listAllByOrderId(Integer orderId);

    OrderItemDto listOneOrderItem(Integer id);

    OrderItemDto createOrderItem(@Valid CreateOrderItemDto orderItemDto);

    OrderItemDto updateOrderItem(@Valid UpdateOrderItemDto orderItemDto);

    void deleteOrderItem(Integer id);
}
