package com.commerce.application.mapper;

import com.commerce.application.dto.orderItem.OrderItemDto;
import com.commerce.application.model.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemMapper orderItemMapper = Mappers.getMapper(OrderItemMapper.class);

    @Mapping(target = "order_id", expression = "java(orderItem.getOrder().getId())")
    @Mapping(target = "product_id", expression = "java(orderItem.getProduct().getId())")
    OrderItemDto toOrderItemDto(OrderItem orderItem);
}
