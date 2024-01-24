package com.example.demo.controller;

import java.io.IOException;
import java.util.LinkedList;

import com.example.demo.model.Event;
import com.example.demo.model.Restaurants;
import com.example.demo.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/event")
public class RestWebController {

    @Autowired
    Restaurants restaurants;

    @Autowired
    RandomService randomService;

    @GetMapping(value = "/all")
    public String getEvents() {
        String jsonMsg = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(restaurants.getEvents());

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }

    @PostMapping("/update")
    String updateForToDay() {
        String today = randomService.getDateFromNow(0);
        LinkedList<Event> events = ((LinkedList<Event>) restaurants.getEvents());
        String toDayTitle = events.getLast().getTitle();
        if (!events.getLast().getStart().equals(today)) {
            events.addLast(new Event(randomService.getRandomRestaurant(toDayTitle, null), today, null));
        }
        return getEvents();
    }

    @PostMapping("/update/sandbox")
    String updateSandbox() {
        String today = randomService.getDateFromNow(0);
        LinkedList<Event> events = ((LinkedList<Event>) restaurants.getEvents());
        String toDayTitle = events.getLast().getTitle();
        if (!events.getLast().getStart().equals(today)) {
            events.addLast(new Event(randomService.getRandomRestaurant(toDayTitle, null), today, null));
        } else {
            String yesterdayTitle = events.get(events.size() - 2).getTitle();
            events.getLast().setTitle(randomService.getRandomRestaurant(toDayTitle, yesterdayTitle));
        }
        return getEvents();
    }


    @GetMapping("/track")
    public String getTracking() {
        return restaurants.toString();
    }
}
