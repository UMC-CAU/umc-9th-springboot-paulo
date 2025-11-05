package com.example.umc_9th_paulo.domain.restaurant.repository;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface RestaurantQueryDsl {
    List<Restaurant> searchRestaurant(Predicate predicate);
}
