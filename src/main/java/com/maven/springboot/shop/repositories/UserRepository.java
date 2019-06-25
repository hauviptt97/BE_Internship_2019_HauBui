package com.maven.springboot.shop.repositories;

import com.maven.springboot.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String username);
}