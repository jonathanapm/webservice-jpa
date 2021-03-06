package com.webservicejpa.services;

import com.webservicejpa.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User insert(User user);

    void delete(Long id);

    User update(Long id, User user);
}
