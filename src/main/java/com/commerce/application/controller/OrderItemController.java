package com.commerce.application.controller;

import com.commerce.application.dto.orderItem.CreateOrderItemDto;
import com.commerce.application.dto.orderItem.OrderItemDto;
import com.commerce.application.dto.orderItem.UpdateOrderItemDto;
import com.commerce.application.service.orderItem.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-item")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<OrderItemDto>> listAllByOrderId(@PathVariable("id") Integer orderId){
        return ResponseEntity.ok(orderItemService.listAllByOrderId(orderId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> listOneOrderItem(@PathVariable("id") Integer id){
        return ResponseEntity.ok(orderItemService.listOneOrderItem(id));
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody @Valid CreateOrderItemDto orderItemDto){
        return ResponseEntity.ok(orderItemService.createOrderItem(orderItemDto));
    }

    @PutMapping
    public ResponseEntity<OrderItemDto> updateOrderItem(@RequestBody @Valid UpdateOrderItemDto orderItemDto){
        return ResponseEntity.ok(orderItemService.updateOrderItem(orderItemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable("id") Integer id){
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
