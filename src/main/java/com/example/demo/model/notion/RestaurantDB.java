package com.example.demo.model.notion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
@Getter
@Setter
@ToString
public class RestaurantDB{
    public String id;
    public String type;
    public ArrayList<Relation> relation;
    public boolean has_more;
}