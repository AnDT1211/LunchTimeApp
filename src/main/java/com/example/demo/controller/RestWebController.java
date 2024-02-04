package com.example.demo.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.Event;
import com.example.demo.model.Restaurants;
import com.example.demo.model.dto.LunchDto;
import com.example.demo.service.LunchServiceImpl;
import com.example.demo.service.RestaurantServiceImpl;
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
    RestaurantServiceImpl restaurantService;

    @Autowired
    LunchServiceImpl lunchService;

    @GetMapping(value = "/all")
    public String getEvents() {
        String jsonMsg = null;
        try {
            List<LunchDto> lunchDtos = lunchService.getAllLunchFromDate(LocalDate.now().minusMonths(3).toString());
            List<Event> events = lunchDtos.stream().map(x -> new Event(x.getName(), x.getPickDate().toString(), null,
                    x.getRestaurant().getColor())).toList();

            ObjectMapper mapper = new ObjectMapper();
            jsonMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
            System.out.println(jsonMsg);

        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonMsg;
    }

    @PostMapping("/update")
    String updateForToDay() {
        try {
            lunchService.registerLunchDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getEvents();
    }

    @PostMapping("/update/sandbox")
    String updateSandbox() {
        try {
            lunchService.registerLunchDateSandbox();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getEvents();
    }
}
