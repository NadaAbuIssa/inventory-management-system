package com.nadaabuissa.Inventory_Management_System_Rest_APIs.controller;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.User;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try{
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(Long.valueOf(id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(Long.valueOf(id), user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUserPartially(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUserPartially(Long.valueOf(id), user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}