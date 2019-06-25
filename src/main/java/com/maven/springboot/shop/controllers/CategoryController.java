package com.maven.springboot.shop.controllers;

import com.maven.springboot.shop.entities.Category;
import com.maven.springboot.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    Optional<Category> findById(@PathVariable int id) {
        return categoryRepository.findById(id);
    }

    @GetMapping
    List<Category> findAll() {
        return categoryRepository.findAll();
    }

//    @DeleteMapping("/{id}")
//    void delete(@PathVariable int id) {
//        categoryRepository.deleteById(id);
//    }
//
//    @PostMapping()
//    void post(@RequestBody ProductDto product) {
//
//        Product x = new Product();
//        x.setName(product.getName());
//        x.setPrice(product.getPrice());
//        x.setSize(product.getSize());
//
//        Category category = new Category();
//        category.setId(product.getCategoryId());
//        x.setCategory(category);
//        categoryRepository.save(x);
//    }
//
//
//    @PutMapping()
//    void put(@RequestBody Product item) {
//        categoryRepository.save(item);
//    }
}

