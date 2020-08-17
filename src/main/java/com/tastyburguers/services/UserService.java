package com.tastyburguers.services;

import java.util.Optional;

import com.tastyburguers.models.User;
import com.tastyburguers.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    
    public User searchById(Integer id) {
        Optional <User> user = repository.findById(id);
        return user.orElse(null);
    }

    public Iterable<User> listAll() {
        Iterable<User> users = repository.findAll();
        return users;
    }
    
    public User searchByUsername(String username) {
        User user = repository.searchByUsername(username);
        return user;
    }
}


