package com.maven.springboot.com.maven.springboot.shop.repositories;

import com.maven.springboot.com.maven.springboot.shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
