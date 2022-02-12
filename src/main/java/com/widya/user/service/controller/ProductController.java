package com.widya.user.service.controller;

import com.widya.user.service.entity.Product;
import com.widya.user.service.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getDetailUser(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product payload) {
        return productService.createNewProduct(payload);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product payload, @PathVariable Long id) {
        return productService.updateProduct(id, payload);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
