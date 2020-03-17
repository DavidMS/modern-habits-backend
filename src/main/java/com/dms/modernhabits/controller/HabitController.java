package com.dms.modernhabits.controller;

import com.dms.modernhabits.model.Habit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/habits")
public class HabitController {

    @GetMapping("/")
    public Habit getHabit() {
        return null;
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public String addHabit(@RequestBody Habit habit) {

        return "OK";
    }
}
