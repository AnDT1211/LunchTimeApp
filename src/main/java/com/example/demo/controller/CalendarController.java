package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.model.Restaurants;
import com.example.demo.service.RandomService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
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

    @PostConstruct
    void init() {
        restaurants.getEvents().add(new Event("cơm gà", LocalDate.now().minusDays(1).toString(), null));
    }

    @PostMapping("/update")
    String toUpdatePage(Model model) {
        String today = LocalDate.now().toString();
        LinkedList<Event> events = ((LinkedList<Event>) restaurants.getEvents());
        if (restaurants.getEvents().isEmpty()) {
            events.addLast(new Event(randomService.getRandomRestaurant(), LocalDate.now().toString(), null));
        } else {
            String toDayReg = events.getLast().getStart();
            if (today.equals(toDayReg)) {
                events.getLast().setTitle(randomService.getRandomRestaurant());
            } else {
                events.addLast(new Event(randomService.getRandomRestaurant(), LocalDate.now().toString(), null));
            }
        }
        return "redirect:/";
    }

    @GetMapping("/todaytest")
    @ResponseBody
    String todaytest() {
        return LocalDate.now().toString();
    }
}
