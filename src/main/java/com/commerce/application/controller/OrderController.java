package com.commerce.application.controller;

import com.commerce.application.dto.order.CreateOrderDto;
import com.commerce.application.dto.order.OrderDto;
import com.commerce.application.dto.order.UpdateOrderDto;
import com.commerce.application.service.order.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderDto>> listAllOrdersByCustomerDocument(@PathVariable("id") Integer id){
        return ResponseEntity.ok(orderService.listAllOrdersByCustomerId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> listOneOrder(@PathVariable("id") Integer id){
        return ResponseEntity.ok(orderService.listOneOrder(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid CreateOrderDto orderDto){
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody @Valid UpdateOrderDto orderDto){
        return ResponseEntity.ok(orderService.updateOrder(orderDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
