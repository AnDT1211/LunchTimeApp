package com.example.demo.controller;

import com.example.demo.model.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @Autowired
    Restaurants restaurants;

    @GetMapping(path = {"/calendar", ""})
    String index() {
        return "index";
    }

    @GetMapping(path = {"/sandbox"})
    String mainPage() {
        return "sandbox";
    }
}
