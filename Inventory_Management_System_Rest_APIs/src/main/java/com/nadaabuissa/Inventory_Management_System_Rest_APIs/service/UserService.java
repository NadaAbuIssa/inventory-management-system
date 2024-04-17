package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User updateUserPartially(Long id, User user);
}