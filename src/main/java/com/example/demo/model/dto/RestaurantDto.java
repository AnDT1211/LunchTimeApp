package com.example.demo.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantDto implements Comparable<RestaurantDto> {
    private String name;
    private String idDb;
    private String address;

    @Override
    public int compareTo(RestaurantDto o) {
        return name.compareTo(o.name) - idDb.compareTo(o.idDb) - address.compareTo(o.address);
    }
}
