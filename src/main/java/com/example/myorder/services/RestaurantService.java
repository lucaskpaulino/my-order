package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateRestaurantDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void createRestaurant(CreateRestaurantDto createRestaurantDto){
        //TODO validações

        Restaurant restaurant = new Restaurant()
                .setEmail(createRestaurantDto.getEmail())
                .setName(createRestaurantDto.getName())
                .setPhone((createRestaurantDto.getPhone()));

        restaurantRepository.save(restaurant);


    }

    public RestaurantResponseDto getById(Integer id) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);

        if(optional.isPresent()) {

            Restaurant restaurant = optional.get();
            return new RestaurantResponseDto()
                    .setId(restaurant.getId())
                    .setEmail(restaurant.getEmail())
                    .setName(restaurant.getName())
                    .setPhone(restaurant.getPhone());
        }

        return null;
    }

}
