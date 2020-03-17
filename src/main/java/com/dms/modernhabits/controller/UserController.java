package com.dms.modernhabits.controller;

import com.dms.modernhabits.model.User;
import com.dms.modernhabits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/{userId}")
    @ResponseBody
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public User insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping(path = "/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
