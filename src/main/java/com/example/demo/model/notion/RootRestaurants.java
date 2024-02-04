package com.example.demo.model.notion;

import com.example.demo.model.dto.RestaurantDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class RootRestaurants{
    public String object;
    public ArrayList<ResultRestaurant> results;
    public Object next_cursor;
    public boolean has_more;
    public String type;
    public PageOrDatabase page_or_database;
    public String developer_survey;
    public String request_id;

    public List<RestaurantDto> getAllRestaurantsDto() {
        return results.stream().map(x -> new RestaurantDto(x.properties.name.title.get(0).text.content
                , x.id, x.properties.address.rich_text.get(0).text.content, x.properties.color.select.name)).toList();
    }
}
