package com.commerce.application.model.entity;

import com.commerce.application.dto.itemReturn.UpdateReturnDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "ItemReturn")
@Table(name = "item_returns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @Enumerated(EnumType.STRING)
    private ReturnStatus status;

    public void actualizar(UpdateReturnDto returnDto) {
        this.status = returnDto.status();
    }
}
