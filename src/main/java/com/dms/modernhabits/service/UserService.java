package com.dms.modernhabits.service;

import com.dms.modernhabits.model.User;

public interface UserService {
    User getUser(int id);
    User insertUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
}
