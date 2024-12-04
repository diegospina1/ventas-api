package com.commerce.application.controller;

import com.commerce.application.dto.product.CreateProductDto;
import com.commerce.application.dto.product.ProductDto;
import com.commerce.application.dto.product.UpdateProductDto;
import com.commerce.application.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> listAllProducts(){
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> listOneProduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(productService.listOneProduct(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid CreateProductDto productDto){
        return ResponseEntity.ok(productService.createProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody @Valid UpdateProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
