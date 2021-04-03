package com.webservicejpa.repository;

import com.webservicejpa.entities.Order;
import com.webservicejpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
