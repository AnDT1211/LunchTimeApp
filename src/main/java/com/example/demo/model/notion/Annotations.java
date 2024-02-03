package com.example.demo.model.notion;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Annotations{
    public boolean bold;
    public boolean italic;
    public boolean strikethrough;
    public boolean underline;
    public boolean code;
    public String color;
}