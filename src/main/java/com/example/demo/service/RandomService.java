package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RandomService {
    public String getRandomRestaurant() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("listrestaurant");
        List<String> keys = Collections.list(resourceBundle.getKeys());
        int size = resourceBundle.keySet().size();
        int idRes = new Random().nextInt(size);

        return resourceBundle.getString(keys.get(idRes));
    }
}
