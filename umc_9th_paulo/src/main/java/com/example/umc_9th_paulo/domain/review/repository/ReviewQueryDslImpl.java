package com.example.umc_9th_paulo.domain.review.repository;


import com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant;
import com.example.umc_9th_paulo.domain.review.entity.QReview;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.user.entity.QUser;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {


    private final EntityManager em;

    @Override
    public List<Review> searchReview(
            Predicate predicate
    ){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Review> searchReviewJoin(
            Predicate predicate
    ){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QReview review = QReview.review;
        QRestaurant restaurant = QRestaurant.restaurant;
        QUser user = QUser.user;

        return queryFactory
                .selectFrom(review)
                .leftJoin(review.restaurant, restaurant).fetchJoin()
                .leftJoin(review.user, user).fetchJoin()
                .where(predicate)
                .fetch();
    }
}
