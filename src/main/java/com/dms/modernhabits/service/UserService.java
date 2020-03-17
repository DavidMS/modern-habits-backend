package com.dms.modernhabits.service;

import com.dms.modernhabits.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUser(int id);
    User insertUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
}
