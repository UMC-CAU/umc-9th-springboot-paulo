package com.example.umc_9th_paulo.domain.restaurant.service;


import com.example.umc_9th_paulo.domain.restaurant.dto.RestaurantResponseDto;
import com.example.umc_9th_paulo.domain.restaurant.entity.QRegion;
import com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.hibernate.usertype.BaseUserTypeSupport;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantResponseDto.searchRestaurant> searchRestaurants(List<String> regionName, String content){
        QRestaurant restaurant = QRestaurant.restaurant;
        QRegion region = QRegion.region;

        BooleanBuilder builder = new BooleanBuilder();

        if(regionName != null && !regionName.isEmpty()) {
            builder.and(region.name.in(regionName));
        }
        if(content != null && !content.isEmpty()) {

            List<String> searchWords = Arrays.stream(content.split(" "))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            if(!searchWords.isEmpty()) {
                BooleanBuilder contentBuilder = new BooleanBuilder();
                for(String searchWord : searchWords) {
                    contentBuilder.or(restaurant.name.containsIgnoreCase(searchWord));
                }
                builder.and(contentBuilder);
            }
        }

        List<Restaurant> restaurantList = restaurantRepository.searchRestaurant(builder);

        return restaurantList.stream()
                .map(temp -> RestaurantResponseDto.searchRestaurant.builder()
                        .score(temp.getStar())
                        .restaurantName(temp.getName())
                        .description(temp.getDescription())
                        .regionName(temp.getRegion().getName())
                        .createdAt(temp.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
