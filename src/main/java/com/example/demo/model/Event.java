package com.example.demo.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event implements Serializable {
    private String title;

    private String start;

    private String end;
}
