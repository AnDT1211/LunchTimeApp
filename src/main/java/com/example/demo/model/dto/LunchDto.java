package com.example.demo.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LunchDto {
    String name;
    String idDb;
    RestaurantDto restaurant;
    LocalDate pickDate;
}
