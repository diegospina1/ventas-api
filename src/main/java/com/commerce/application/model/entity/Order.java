package com.commerce.application.model.entity;

import com.commerce.application.dto.order.UpdateOrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Order")
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    private LocalDateTime order_date;
    private LocalDateTime delivered_date;

    public void actualizar(UpdateOrderDto orderDto) {
        if (orderDto.delivered_date() != null) {
            this.delivered_date = orderDto.delivered_date();
        }
    }
}
