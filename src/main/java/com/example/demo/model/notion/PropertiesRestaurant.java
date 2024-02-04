package com.example.demo.model.notion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PropertiesRestaurant{
    @JsonProperty("Address")
    public Address address;
    @JsonProperty("Name")
    public Name name;
    @JsonProperty("Color")
    public Color color;
}
