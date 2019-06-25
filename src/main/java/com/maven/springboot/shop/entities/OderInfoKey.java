package com.maven.springboot.shop.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
class OderInfoKey implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "product_id")
    private int productId;

}