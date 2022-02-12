package com.widya.user.service.service;

import com.widya.user.service.entity.Product;
import com.widya.user.service.repository.ProductRepository;
import com.widya.user.service.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found id :" + id));
    }

    @Override
    public Product createNewProduct(Product payload) {
        return productRepository.save(payload);
    }

    @Override
    public Product updateProduct(Long id, Product payload) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found with id :" + id));

        productById.setName(payload.getName());
        productById.setStock(payload.getStock());
        productById.setPrice(payload.getPrice());

        productRepository.save(productById);

        return productById;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found with id :" + id));

        productRepository.delete(productById);

        return productById;
    }
}
