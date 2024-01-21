package com.example.demo.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Restaurants implements Serializable {
    private List<Event> events = new LinkedList<>();
}
