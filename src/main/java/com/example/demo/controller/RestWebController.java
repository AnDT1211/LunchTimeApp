package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.demo.model.Restaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/event")
public class RestWebController {

    @Autowired
    Restaurants restaurants;

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

    @GetMapping("/track")
    public String getTracking() {
        return restaurants.toString();
    }
}
