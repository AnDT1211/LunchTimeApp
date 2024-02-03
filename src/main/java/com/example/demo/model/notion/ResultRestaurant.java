package com.example.demo.model.notion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultRestaurant {
    public String object;
    public String id;
    public String created_time;
    public String last_edited_time;
    public CreatedBy created_by;
    public LastEditedBy last_edited_by;
    public Object cover;
    public Object icon;
    public Parent parent;
    public boolean archived;
    public PropertiesRestaurant properties;
    public String url;
    public Object public_url;
}