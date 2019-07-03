package com.maven.springboot.shop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderInfo{

    @EmbeddedId
    OderInfoKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @Column(name = "amount")
    private int amount;

    
}
