package com.example.umc_9th_paulo.domain.review.repository;


import com.example.umc_9th_paulo.domain.review.entity.QReview;
import com.example.umc_9th_paulo.domain.review.entity.Review;
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
}
