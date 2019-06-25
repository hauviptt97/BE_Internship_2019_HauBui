package com.maven.springboot.shop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String size;

    private double price;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

}
