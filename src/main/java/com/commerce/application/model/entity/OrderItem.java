package com.commerce.application.model.entity;

import com.commerce.application.dto.orderItem.UpdateOrderItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "OrderItem")
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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


    public void actualizar(UpdateOrderItemDto orderItemDto, Float newPrice) {
        if (orderItemDto.quantity() != null) {
            this.quantity = orderItemDto.quantity();
        }
        this.total_price = newPrice;
    }
}
