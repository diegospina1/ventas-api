package com.commerce.application.service.product;

import com.commerce.application.model.entity.Product;

public interface ProductSearch {

    Product findProductById(Integer id);
    Boolean productExistsById(Integer id);
}
