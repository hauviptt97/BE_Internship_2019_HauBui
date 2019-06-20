package com.maven.springboot.com.maven.springboot.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="orders")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;

    private String address;

    private String transportationForm;

}
