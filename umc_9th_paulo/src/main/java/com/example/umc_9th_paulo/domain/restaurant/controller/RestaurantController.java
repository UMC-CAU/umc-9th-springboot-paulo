package com.example.umc_9th_paulo.domain.restaurant.controller;

import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantRequestDto;
import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantResponseDto;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RestaurantSuccessCode;
import com.example.umc_9th_paulo.domain.restaurant.service.RestaurantQueryService;
import com.example.umc_9th_paulo.domain.restaurant.service.RestaurantService;
import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import com.example.umc_9th_paulo.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantQueryService restaurantQueryService;
    private final RestaurantService restaurantService;

    @GetMapping
    @Operation(summary = "식당 검색 API")
    public ApiResponse<Page<RestaurantResponseDto.searchRestaurant>> searchRestaurant(
            @RequestParam(value = "regionName", required = false) List<String> regionName,
            @RequestParam(value = "content", required = false) String content,
            @PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ApiResponse.onSuccess(GeneralSuccessCode._OK,restaurantQueryService.searchRestaurants(regionName, content, pageable));
    }

    @PostMapping
    @Operation(summary = "식당 생성 API")
    public ApiResponse<RestaurantResponseDto.RestaurantMakeDto> makeRestaurant(
            @RequestBody RestaurantRequestDto.RestaurantMakeDto dto
    ){
        return ApiResponse.onSuccess(RestaurantSuccessCode.OK, restaurantService.makeRestaurant(dto));
    }
}
