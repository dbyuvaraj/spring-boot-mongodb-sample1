package com.sample.springboot.mongodb.service.impl;

import com.sample.springboot.mongodb.domain.Product;
import com.sample.springboot.mongodb.repository.ProductRepository;
import com.sample.springboot.mongodb.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
