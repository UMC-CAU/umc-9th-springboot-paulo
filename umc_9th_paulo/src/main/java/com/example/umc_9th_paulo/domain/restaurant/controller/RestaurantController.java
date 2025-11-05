package com.example.umc_9th_paulo.domain.restaurant.controller;

import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantResponseDto;
import com.example.umc_9th_paulo.domain.restaurant.service.RestaurantQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantQueryService restaurantQueryService;
    @GetMapping
    @Operation(summary = "식당 검색 API")
    public List<RestaurantResponseDto.searchRestaurant> searchRestaurant(
            @RequestParam(value = "regionName", required = false) List<String> regionName,
            @RequestParam(value = "content", required = false) String content) {
        return restaurantQueryService.searchRestaurants(regionName, content);
    }
}
