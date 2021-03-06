package com.dms.modernhabits.service.impl;

import com.dms.modernhabits.model.User;
import com.dms.modernhabits.repository.StatsRepository;
import com.dms.modernhabits.repository.UserRepository;
import com.dms.modernhabits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatsRepository statsRepository;

    @Override
    public Optional<User> getUser(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User insertUser(User user) {
        var stats = user.getStats();
        user.setStats(null);
        var userInsert = userRepository.save(user);
        stats.setUser(userInsert);
        var statsInsert = statsRepository.save(stats);
        user.setStats(statsInsert);
        return user;
    }

    @Override
    public User updateUser(User user) {
        var stats = user.getStats();
        user.setStats(null);
        var userInsert = userRepository.save(user);
        stats.setUser(userInsert);
        var statsInsert = statsRepository.save(stats);
        user.setStats(statsInsert);
        return user;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
