package com.sample.springboot.mongodb.service;

import com.sample.springboot.mongodb.domain.Product;
import com.sample.springboot.mongodb.exception.AppException;

import java.util.List;

public interface IProductService {

    Product create(Product product);

    Product getProductById(String id) throws AppException;

    List<Product> getAllProducts();
}
