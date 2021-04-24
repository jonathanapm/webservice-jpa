package com.webservicejpa.services;

import com.webservicejpa.entities.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> findAll();

    OrderItem findById(Long id);

}
