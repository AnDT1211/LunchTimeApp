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

    @PostConstruct
    void init() {
        restaurants.getEvents().add(new Event("Cơm gà", randomService.getDateFromNow(-1), null));
        restaurants.getEvents().add(new Event("Cơm phần 1", randomService.getDateFromNow(0), null));
    }

    @PostMapping("/update")
    String toUpdatePage() {
        String today = randomService.getDateFromNow(0);
        LinkedList<Event> events = ((LinkedList<Event>) restaurants.getEvents());
        String toDayTitle = events.getLast().getTitle();
        if (!events.getLast().getStart().equals(today)) {
            events.addLast(new Event(randomService.getRandomRestaurant(toDayTitle, null), today, null));
        } else {
            String yesterdayTitle = events.get(events.size() - 2).getTitle();
            events.getLast().setTitle(randomService.getRandomRestaurant(toDayTitle, yesterdayTitle));
        }
        return "redirect:/";
    }

    @GetMapping("/todaytest")
    @ResponseBody
    String todaytest() {
        return LocalDate.now().toString();
    }
}
