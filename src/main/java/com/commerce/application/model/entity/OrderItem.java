package com.commerce.application.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "OrderItem")
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Order.class)
    private Order order;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    private Integer quantity;
    private Float total_price;
}
