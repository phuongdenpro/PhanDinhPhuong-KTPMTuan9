package com.example.springbootrediscrud.controller;


import com.example.springbootrediscrud.entity.Product;
import com.example.springbootrediscrud.repository.ProductRepository;
import com.example.springbootrediscrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RedisTemplate template;

    @PostMapping
    public Product save(@RequestBody Product product) {
        product = productService.addProduct(product);
        template.opsForHash().put("product", product.getId(), product);
        return product;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return template.opsForHash().values("product");
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return (Product) template.opsForHash().get("product",id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        template.opsForHash().delete("product",id);
        return "product removed !!";
    }

}
