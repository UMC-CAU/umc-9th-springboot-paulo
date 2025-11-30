package com.example.umc_9th_paulo.domain.restaurant.converter;

import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantRequestDto;
import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantResponseDto;
import com.example.umc_9th_paulo.domain.restaurant.entity.Region;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;

public class RestaurantConverter {
    public static RestaurantResponseDto.RestaurantMakeDto toRestaurantMakeDto(Restaurant restaurant) {
        return RestaurantResponseDto.RestaurantMakeDto.builder()
                .restaurnatId(restaurant.getId())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDto.RestaurantMakeDto reqRestaurant, Region region) {
        return Restaurant.builder()
                .restaurantType(reqRestaurant.resType())
                .name(reqRestaurant.name())
                .address(reqRestaurant.address())
                .latitude(reqRestaurant.latitude())
                .longitude(reqRestaurant.longitude())
                .description(reqRestaurant.description())
                .star(reqRestaurant.star())
                .region(region)
                .build();
    }
}
