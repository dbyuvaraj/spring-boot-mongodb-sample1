package com.sample.springboot.mongodb.controller;

import com.sample.springboot.mongodb.domain.Product;
import com.sample.springboot.mongodb.service.IProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/find")
    public Product find(@RequestParam("id") String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/list")
    public List<Product> find() {
        return productService.getAllProducts();
    }

}
