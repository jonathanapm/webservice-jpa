package com.webservicejpa.services;

import com.webservicejpa.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);
}
