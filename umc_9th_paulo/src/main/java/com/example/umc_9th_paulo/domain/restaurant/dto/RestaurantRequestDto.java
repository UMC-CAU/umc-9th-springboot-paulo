package com.example.umc_9th_paulo.domain.restaurant.dto;

import com.example.umc_9th_paulo.domain.restaurant.enums.ResType;

public class RestaurantRequestDto {

    public record RestaurantMakeDto(
            String name,
            Double latitude,
            Double longitude,
            String address,
            Integer star,
            String description,
            ResType resType,
            Long regionId
    ){}
}
