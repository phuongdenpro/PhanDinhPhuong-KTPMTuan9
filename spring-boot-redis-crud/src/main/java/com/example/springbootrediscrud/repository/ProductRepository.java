package com.example.springbootrediscrud.repository;

import com.example.springbootrediscrud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductRepository  extends CrudRepository<Product, String> {
    Product findByProductId(int id);
    void deleteByProductId(int id);

}