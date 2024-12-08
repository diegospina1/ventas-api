package com.commerce.application.model.entity;

import com.commerce.application.dto.product.CreateProductDto;
import com.commerce.application.dto.product.UpdateProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Product")
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    private Integer stock;
    private Float price;

    public Product(CreateProductDto productDto) {
        this.name = productDto.name();
        this.category = productDto.category();
        this.stock = productDto.stock();
        this.price = productDto.price();
    }

    public void actualizar(UpdateProductDto productDto) {
        if(productDto.name() != null){
            this.name = productDto.name();
        }
        if (productDto.category() != null) {
            this.category = productDto.category();
        }
        if (productDto.stock() != null) {
            this.stock = productDto.stock();
        }
        if (productDto.price() != null) {
            this.price = productDto.price();
        }
    }
}
