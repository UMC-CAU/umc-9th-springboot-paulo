package com.example.umc_9th_paulo.domain.review.service;

import com.example.umc_9th_paulo.domain.restaurant.entity.QRegion;
import com.example.umc_9th_paulo.domain.restaurant.entity.QRestaurant;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.QReview;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.entity.ReviewPhoto;
import com.example.umc_9th_paulo.domain.review.repository.ReviewRepository;
import com.example.umc_9th_paulo.domain.user.entity.QUser;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public List<ReviewResponseDto.searchReview> searchReview(String restaurantName, Float star, Long userId, Integer type) {
        QReview review = QReview.review;
        QRestaurant restaurant = QRestaurant.restaurant;
        QUser user = QUser.user;
        BooleanBuilder builder = new BooleanBuilder();


        List<Review> reviewList;

        if(type == 1) {
            builder.and(review.user.id.eq(userId));
            if(restaurantName != null) {
                builder.and(review.restaurant.name.eq(restaurantName));
            }
            if(star != null) {
                builder.and(review.score.goe(star));
            }

            reviewList = reviewRepository.searchReview(builder);
        }
        else {
            builder.and(user.id.eq(userId));
            if(restaurantName != null) {
                builder.and(restaurant.name.eq(restaurantName));
            }
            if(star != null) {
                builder.and(review.score.goe(star));
            }

            reviewList = reviewRepository.searchReviewJoin(builder);
        }

        return reviewList.stream()
                .map(temp -> ReviewResponseDto.searchReview.builder()
                        .star(temp.getScore())
                        .restaurantName(temp.getRestaurant().getName())
                        .content(temp.getContent())
                        .images(temp.getReviewPhotos().stream()
                                .map(ReviewPhoto::getImageUrl)
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}
