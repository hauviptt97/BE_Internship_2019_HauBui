package com.maven.springboot.shop.repositories;

import com.maven.springboot.shop.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}