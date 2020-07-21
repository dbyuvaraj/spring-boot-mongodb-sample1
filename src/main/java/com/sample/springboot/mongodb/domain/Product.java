package com.sample.springboot.mongodb.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("products")
public class Product {

    @Id
    public String id;
    public String name;
    public int quantity;

    public Product() {
    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }



}
