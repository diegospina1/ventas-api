package com.commerce.application.mapper;

import com.commerce.application.dto.order.OrderDto;
import com.commerce.application.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "customer_id", expression = "java(order.getCustomer().getId())")
    OrderDto toOrderDto(Order order);
}
