package com.maven.springboot.com.maven.springboot.shop.repositories;

import com.maven.springboot.com.maven.springboot.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
