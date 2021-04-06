package com.webservicejpa.controller;

import com.webservicejpa.entities.Product;
import com.webservicejpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductFindById(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
