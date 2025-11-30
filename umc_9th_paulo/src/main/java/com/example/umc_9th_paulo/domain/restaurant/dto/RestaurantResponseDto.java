package com.example.umc_9th_paulo.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class RestaurantResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class searchRestaurant{
        String regionName;
        String restaurantName;
        Integer score;
        String description;
        LocalDateTime createdAt;
    }

    @Builder
    public record RestaurantMakeDto(
            Long restaurnatId,
            LocalDateTime createdAt
    ){}
}
