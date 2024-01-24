package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.model.Restaurants;
import com.example.demo.service.RandomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Controller
public class CalendarController {

    @Autowired
    Restaurants restaurants;

    @Autowired
    RandomService randomService;

    @GetMapping(path = {"/calendar", ""})
    String index() {
        return "index";
    }

    @GetMapping(path = {"/sandbox"})
    String mainPage() {
        return "sandbox";
    }

    @PostConstruct
    void init() {
        restaurants.getEvents().add(new Event("Cơm gà", randomService.getDateFromNow(-2), null));
        restaurants.getEvents().add(new Event("Cơm phần 1", randomService.getDateFromNow(-1), null));
        restaurants.getEvents().add(new Event("Bún bò", randomService.getDateFromNow(0), null));
    }

}
