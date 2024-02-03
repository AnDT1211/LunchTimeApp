package com.example.demo.model.notion;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class Result{
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
    public Properties properties;
    public String url;
    public Object public_url;
}