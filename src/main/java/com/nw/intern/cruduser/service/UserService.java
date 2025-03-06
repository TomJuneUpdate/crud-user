package com.nw.intern.cruduser.service;

import com.nw.intern.cruduser.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);
}