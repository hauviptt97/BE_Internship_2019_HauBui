package com.maven.springboot.shop.controllers;

import com.maven.springboot.shop.entities.Product;
import com.maven.springboot.shop.entities.ProductDto;
import com.maven.springboot.shop.repositories.CategoryRepository;
import com.maven.springboot.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    Optional<Product> findById(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @GetMapping
    List<Product> findAll() {
        return productRepository.findAll();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody ProductDto productDto) {

        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setSize(productDto.getSize());
        product.setCategory(categoryRepository.findById(productDto.getCategoryId()).orElse(null));

        productRepository.save(product);

    }

    @PutMapping()
    void put(@RequestBody Product item) {
        productRepository.save(item);
    }
}

