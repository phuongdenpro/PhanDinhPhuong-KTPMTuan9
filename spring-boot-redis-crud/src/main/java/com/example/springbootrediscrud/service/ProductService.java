package com.example.springbootrediscrud.service;

import com.example.springbootrediscrud.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> findAll();
    Product findProductById(int id);
    void deleteProductById(int id);
}
