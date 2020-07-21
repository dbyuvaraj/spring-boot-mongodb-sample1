package com.sample.springboot.mongodb.service;

import com.sample.springboot.mongodb.domain.Product;

import java.util.List;

public interface IProductService {

    Product create(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();
}
