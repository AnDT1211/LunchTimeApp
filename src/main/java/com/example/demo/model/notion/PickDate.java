package com.example.demo.model.notion;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PickDate{
    public String id;
    public String type;
    public Date date;
}