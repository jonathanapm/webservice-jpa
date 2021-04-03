package com.webservicejpa.services;

import com.webservicejpa.entities.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    Order findById(Long id);
}
