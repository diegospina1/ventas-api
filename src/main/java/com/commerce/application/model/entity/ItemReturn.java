package com.commerce.application.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "ItemReturn")
@Table(name = "item_returns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = OrderItem.class)
    private OrderItem orderItem;
    @ManyToOne(targetEntity = CompanyBranch.class)
    private CompanyBranch companyBranch;
    private String reason;
    private Integer quantity;
    private LocalDateTime return_date;
}
