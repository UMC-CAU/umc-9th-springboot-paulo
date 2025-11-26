package com.example.umc_9th_paulo.domain.restaurant.service;

import com.example.umc_9th_paulo.domain.restaurant.converter.RestaurantConverter;
import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantRequestDto;
import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantResponseDto;
import com.example.umc_9th_paulo.domain.restaurant.entity.Region;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.restaurant.exception.RegionException;
import com.example.umc_9th_paulo.domain.restaurant.exception.RestaurantException;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RegionErrorCode;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc_9th_paulo.domain.restaurant.repository.RegionRepository;
import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public RestaurantResponseDto.RestaurantMakeDto makeRestaurant(RestaurantRequestDto.RestaurantMakeDto dto) {

        Region region = regionRepository.findById(dto.regionId()).orElseThrow(() -> new RegionException(RegionErrorCode.NOT_FOUND));
        // 식당 중복 검사
        if(restaurantRepository.existsByNameAndAddress(dto.name(), dto.address())){
            throw new RestaurantException(RestaurantErrorCode.RESTAURANT_ALREADY_EXISTS);
        }

        Restaurant restaurant = RestaurantConverter.toRestaurant(dto, region);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return RestaurantConverter.toRestaurantMakeDto(savedRestaurant);
    }
}
