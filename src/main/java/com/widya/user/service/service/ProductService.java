package com.widya.user.service.service;

import com.widya.user.service.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createNewProduct(Product payload);
    Product updateProduct(Long id, Product payload);
    Product deleteProduct(Long id);
}
