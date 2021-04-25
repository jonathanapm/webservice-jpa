package com.webservicejpa.services.impl;

import com.webservicejpa.entities.User;
import com.webservicejpa.exceptions.DatabaseException;
import com.webservicejpa.exceptions.ResourceNotFoundException;
import com.webservicejpa.repository.UserRepository;
import com.webservicejpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DatabaseException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public User update(Long id, User user) {
        try {
            /**Instância o usuário e não acessa o banco de dados por enquanto, ou seja
             a classe é monitorada e podemos trabalhar com ela**/
            User entity = userRepository.getOne(id);

            updateData(entity, user);

            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    private void updateData(User entity, User obj) {
        entity.setEmail(obj.getEmail());
        entity.setName(obj.getName());
        entity.setPhone(obj.getPhone());
    }
}
