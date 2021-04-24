package com.webservicejpa.services.impl;

import com.webservicejpa.entities.User;
import com.webservicejpa.repository.UserRepository;
import com.webservicejpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }
}
