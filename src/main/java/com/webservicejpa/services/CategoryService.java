package com.webservicejpa.services;

import com.webservicejpa.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);
}
