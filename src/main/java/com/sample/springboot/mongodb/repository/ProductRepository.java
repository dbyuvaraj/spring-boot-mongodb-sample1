package com.sample.springboot.mongodb.repository;

import com.sample.springboot.mongodb.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
