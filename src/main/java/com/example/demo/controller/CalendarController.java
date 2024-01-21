package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.model.Restaurants;
import com.example.demo.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
