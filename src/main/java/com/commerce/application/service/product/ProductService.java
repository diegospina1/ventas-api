package com.commerce.application.service.product;

import com.commerce.application.dto.product.CreateProductDto;
import com.commerce.application.dto.product.ProductDto;
import com.commerce.application.dto.product.UpdateProductDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService extends ProductSearch{
    List<ProductDto> listAllProducts();

    ProductDto listOneProduct(Integer id);

    ProductDto createProduct(@Valid CreateProductDto productDto);

    ProductDto updateProduct(@Valid UpdateProductDto productDto);

    void deleteProduct(Integer id);
}
