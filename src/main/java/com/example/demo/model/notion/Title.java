package com.example.demo.model.notion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Title{
    public String type;
    public Text text;
    public Annotations annotations;
    public String plain_text;
    public Object href;
}