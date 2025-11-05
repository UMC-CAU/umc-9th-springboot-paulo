package com.example.umc_9th_paulo.domain.restaurant.repository;

import com.example.umc_9th_paulo.domain.restaurant.entity.QRegion;
import com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantQueryDslImpl implements RestaurantQueryDsl {

    private final EntityManager em;

    @Override
    public Page<Restaurant> searchRestaurant(Predicate predicate, Pageable pageable, OrderSpecifier<?>... orderSpecifiers) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QRestaurant restaurant = QRestaurant.restaurant;
        QRegion region = QRegion.region;

        List<Restaurant> content = queryFactory
                .selectFrom(restaurant)
                .leftJoin(restaurant.region, region).fetchJoin()
                .where(predicate)
                .orderBy(orderSpecifiers)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(restaurant.count())
                .from(restaurant)
                .join(restaurant.region, region) // ◀ 조인/Where 조건 동일하게 적용
                .where(predicate)
                .fetchOne();

        if(total == null) {
            total = 0L;
        }
        return new PageImpl<>(content, pageable, total);
    }
}
