package com.commerce.application.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Order")
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    private LocalDateTime order_date;
    private LocalDateTime delivered_date;

}
