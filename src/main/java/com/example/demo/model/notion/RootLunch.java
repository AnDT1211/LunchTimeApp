package com.example.demo.model.notion;

import com.example.demo.model.dto.LunchDto;
import com.example.demo.model.dto.RestaurantDto;
import com.example.demo.service.RestaurantServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class RootLunch {
    public String object;
    public ArrayList<Result> results;
    public Object next_cursor;
    public boolean has_more;
    public String type;
    public PageOrDatabase page_or_database;
    public String developer_survey;
    public String request_id;

    private final RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();

    public List<LunchDto> getAllLunch() throws Exception {
        List<RestaurantDto> restaurantDtos = restaurantService.getAllRestaurant();

        return results.stream().map(x -> {
            for (RestaurantDto res : restaurantDtos) {
                if (res.getIdDb().equals(x.getProperties().restaurantDB.relation.get(0).id)) {
                    return new LunchDto(x.properties.name.title.get(0).text.content,
                            x.id, res, LocalDate.parse(x.properties.pick_Date.date.start));
                }
            }
            return null;

        }).toList();
    }
}
