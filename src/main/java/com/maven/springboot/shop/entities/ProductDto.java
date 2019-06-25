package com.maven.springboot.shop.entities;

import lombok.Data;

@Data
public class ProductDto {
    private int id;

    private String name;

    private double price;

    private String size;

    private int categoryId;

}
