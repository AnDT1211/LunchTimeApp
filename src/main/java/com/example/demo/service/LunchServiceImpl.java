package com.example.demo.service;

import com.example.demo.model.dto.LunchDto;
import com.example.demo.model.dto.RestaurantDto;
import com.example.demo.model.notion.RootLunch;
import com.example.demo.repository.LunchRepoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LunchServiceImpl {
    LunchRepoImpl lunchRepo = new LunchRepoImpl();

    @Autowired
    RestaurantServiceImpl restaurantService;

    ObjectMapper objectMapper = new ObjectMapper();

    public List<LunchDto> getAllLunch() throws Exception {
        String res = lunchRepo.queryDbAll("71e18f544ff94bc1babfcbec6e106f66");
        RootLunch rootLunch = objectMapper.readValue(res, RootLunch.class);

        return rootLunch.getAllLunch();
    }

    public List<LunchDto> getAllLunchFromDate(String date) throws Exception {
        String res = lunchRepo.queryDbAllFromDate("71e18f544ff94bc1babfcbec6e106f66", date);
        RootLunch rootLunch = objectMapper.readValue(res, RootLunch.class);

        return rootLunch.getAllLunch();
    }

    public void registerLunchDate() throws Exception {
        List<LunchDto> lunchDtos = new ArrayList<>(getAllLunchFromDate(getDateFromNow(0).minusMonths(3).toString()));
        lunchDtos.sort((a, b) -> b.getPickDate().compareTo(a.getPickDate()));

        if(!getDateFromNow(0).toString().equals(lunchDtos.get(0).getPickDate().toString())) {
            List<RestaurantDto> restaurantDtos = restaurantService.getAllRestaurant();
            RestaurantDto picked = restaurantDtos.get(new Random().nextInt(restaurantDtos.size()));
            while(picked.getName().equals(lunchDtos.get(0).getName())) {
                picked = restaurantDtos.get(new Random().nextInt(restaurantDtos.size()));
            }
            lunchRepo.ChooseARestaurant("71e18f544ff94bc1babfcbec6e106f66", picked.getIdDb(), picked.getName(), LocalDate.now().toString());
        }

//        RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();
//        List<RestaurantDto> restaurantDtos = restaurantService.getAllRestaurant();
//        RestaurantDto picked = restaurantDtos.get(new Random().nextInt(restaurantDtos.size()));
//        System.out.println(picked);
//        lunchRepo.ChooseARestaurant("71e18f544ff94bc1babfcbec6e106f66", picked.getIdDb(), picked.getName(), LocalDate.now().toString());
    }

    public void registerLunchDateSandbox() throws Exception {  // chua xong
        List<LunchDto> lunchDtos = new ArrayList<>(getAllLunchFromDate(getDateFromNow(0).minusMonths(3).toString()));
        lunchDtos.sort((a, b) -> b.getPickDate().compareTo(a.getPickDate()));

        if(!getDateFromNow(0).toString().equals(lunchDtos.get(0).getPickDate().toString())) {
            List<RestaurantDto> restaurantDtos = restaurantService.getAllRestaurant();
            RestaurantDto picked = restaurantDtos.get(new Random().nextInt(restaurantDtos.size()));
            while(picked.getName().equals(lunchDtos.get(0).getName())) {
                picked = restaurantDtos.get(new Random().nextInt(restaurantDtos.size()));
            }
            lunchRepo.ChooseARestaurant("71e18f544ff94bc1babfcbec6e106f66", picked.getIdDb(), picked.getName(), LocalDate.now().toString());
        }

//        RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();
//        List<RestaurantDto> restaurantDtos = restaurantService.getAllRestaurant();
//        RestaurantDto picked = restaurantDtos.get(new Random().nextInt(restaurantDtos.size()));
//        System.out.println(picked);
//        lunchRepo.ChooseARestaurant("71e18f544ff94bc1babfcbec6e106f66", picked.getIdDb(), picked.getName(), LocalDate.now().toString());
    }


    public LocalDate getDateFromNow(int days) {
        LocalDate date = LocalDate.ofInstant(Instant.now(), ZoneId.of("UTC+07"));
        date = date.plusDays(days);
        return date;
    }
}
