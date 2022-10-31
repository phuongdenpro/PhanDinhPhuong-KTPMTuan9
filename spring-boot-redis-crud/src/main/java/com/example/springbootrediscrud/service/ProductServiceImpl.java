package com.example.springbootrediscrud.service;

import com.example.springbootrediscrud.entity.Product;
import com.example.springbootrediscrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findByProductId(id);
    }

    @Override
    public void deleteProductById(int id) {
         productRepository.deleteByProductId(id);

    }
}
