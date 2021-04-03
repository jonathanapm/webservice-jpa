package com.webservicejpa.controller;

import com.webservicejpa.entities.User;
import com.webservicejpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> u = userService.findAll();
        return ResponseEntity.ok().body(u);
    }

    @GetMapping("/filter-user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }


}
