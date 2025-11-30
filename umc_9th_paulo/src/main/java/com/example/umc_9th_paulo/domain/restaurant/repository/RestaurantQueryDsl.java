package com.example.umc_9th_paulo.domain.restaurant.repository;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantQueryDsl {
    Page<Restaurant> searchRestaurant(Predicate predicate, Pageable pageable, OrderSpecifier<?>... orderSpecifiers);
}
