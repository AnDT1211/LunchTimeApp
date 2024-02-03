package com.example.demo.service;

import com.example.demo.model.dto.RestaurantDto;
import com.example.demo.model.notion.RootRestaurants;
import com.example.demo.repository.RestaurantRepoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl {
    private RestaurantRepoImpl restaurantRepo = new RestaurantRepoImpl();

    ObjectMapper objectMapper = new ObjectMapper();

    public List<RestaurantDto> getAllRestaurant() throws Exception {
        RootRestaurants rootRestaurants = objectMapper.readValue(restaurantRepo.queryDbAll(), RootRestaurants.class);
        return rootRestaurants.getAllRestaurantsDto();
    }



}
