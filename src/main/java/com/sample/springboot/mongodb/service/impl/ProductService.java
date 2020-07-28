package com.sample.springboot.mongodb.service.impl;

import com.sample.springboot.mongodb.domain.Product;
import com.sample.springboot.mongodb.exception.AppException;
import com.sample.springboot.mongodb.exception.ErrorCode;
import com.sample.springboot.mongodb.repository.ProductRepository;
import com.sample.springboot.mongodb.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository,
                          @Value("${public-key}") String key) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String id) throws AppException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            log.info("Exception while getting the product for {}", id);
            throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
