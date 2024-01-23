package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class RandomService {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("listrestaurant");
    public String getDateFromNow(int days) {
        LocalDate date = LocalDate.ofInstant(Instant.now(), ZoneId.of("UTC+07"));
        date = date.plusDays(days);
        return date.toString();
    }

    public String getRandomRestaurant(String toDayTitle, String yesterdayTitle) {
        System.out.println(toDayTitle);
        System.out.println(yesterdayTitle);
        List<String> keys = Collections.list(resourceBundle.getKeys());
        int size = resourceBundle.keySet().size();
        int idRes = new Random().nextInt(size);
        String newTitle = resourceBundle.getString(keys.get(idRes));
        System.out.println("new " + newTitle);

        while (Objects.equals(newTitle, toDayTitle) || Objects.equals(newTitle, yesterdayTitle)) {
            idRes = new Random().nextInt(size);
            newTitle = resourceBundle.getString(keys.get(idRes));
        }

        return newTitle;
    }
}
