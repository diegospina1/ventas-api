package com.commerce.application.service.product;

import com.commerce.application.dto.product.CreateProductDto;
import com.commerce.application.dto.product.ProductDto;
import com.commerce.application.dto.product.UpdateProductDto;
import com.commerce.application.model.entity.Product;
import com.commerce.application.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.commerce.application.mapper.ProductMapper.productMapper;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> listAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto listOneProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return productMapper.toProductDto(product);
    }

    @Override
    public ProductDto createProduct(CreateProductDto productDto) {
        Product product = new Product(productDto);
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(UpdateProductDto productDto) {
        Product product = productRepository.findById(productDto.id())
                .orElseThrow(EntityNotFoundException::new);
        product.actualizar(productDto);
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Integer id) {

    }
}
