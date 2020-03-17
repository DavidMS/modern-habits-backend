package com.dms.modernhabits.controller;

import com.dms.modernhabits.model.User;
import com.dms.modernhabits.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{userId}")
    @ResponseBody
    public User getUser(@PathVariable int userId) {
        LOGGER.info("Getting user with id: %d", userId);
        return userService.getUser(userId).orElse(null);
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public User insertUser(@RequestBody User user) {
        LOGGER.info("Inserting user %s", user.getName());
        return userService.insertUser(user);
    }

    @PostMapping(path = "/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        LOGGER.info("Updating user %d", user.getId());
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        LOGGER.info("Deleting user %d", userId);
        userService.deleteUser(userId);
    }
}
