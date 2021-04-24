package com.webservicejpa.services.impl;

import com.webservicejpa.entities.OrderItem;
import com.webservicejpa.repository.OrderItemRepository;
import com.webservicejpa.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(Long id) {
        return orderItemRepository.findById(id).get();
    }
}
