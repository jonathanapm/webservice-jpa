package com.webservicejpa.services.impl;

import com.webservicejpa.entities.User;
import com.webservicejpa.exceptions.ResourceNotFoundException;
import com.webservicejpa.repository.UserRepository;
import com.webservicejpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {

        /**Instância o usuário e não acessa o banco de dados por enquanto, ou seja
        a classe é monitororada e podemos trabalhar com ela**/
        User entity = userRepository.getOne(id);
        updateData(entity, user);

        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }
}
