package com.tastyburguers.controllers;

import com.tastyburguers.models.User;
import com.tastyburguers.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

/*
    @GetMapping(value="/", produces = "application/json")
    public ResponseEntity<Iterable<User>> get() throws Exception {
        User users = userService.listAll();
        return ResponseEntity.ok(users);
    }
*/

    @GetMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<User> get(@PathVariable Integer id) throws Exception {
        User user = userService.searchById(id);
        return ResponseEntity.ok(user);
    }

    /*
    @GetMapping(value="/{username}", produces = "application/json")
    public ResponseEntity<User> get(@PathVariable String username) {
        User user = userService.searchByUsername(username);
        return ResponseEntity.ok(user);
    }
    */
    
}