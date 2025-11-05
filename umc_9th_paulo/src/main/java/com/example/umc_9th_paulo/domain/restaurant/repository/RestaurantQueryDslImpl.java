package com.example.umc_9th_paulo.domain.restaurant.repository;

import com.example.umc_9th_paulo.domain.restaurant.entity.QRegion;
import com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantQueryDslImpl implements RestaurantQueryDsl {

    private final EntityManager em;

    @Override
    public List<Restaurant> searchRestaurant(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QRestaurant restaurant = QRestaurant.restaurant;
        QRegion region = QRegion.region;

        return queryFactory
                .selectFrom(restaurant)
                .leftJoin(region).on(restaurant.region.id.eq(region.id))
                .where(predicate)
                .orderBy(orderSpecifiers)
                .fetch();
    }
}
