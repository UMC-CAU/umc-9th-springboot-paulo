package com.example.umc_9th_paulo.domain.review.converter;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.review.dto.ReviewRequestDto;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.user.entity.User;

public class ReviewConverter {
    public static ReviewResponseDto.CreateReview1 toCreateReview(Review review){
        return ReviewResponseDto.CreateReview1.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toCreateReview(ReviewRequestDto.CreateReview1 dto, User user, Restaurant restaurant){
        return Review.builder()
                .content(dto.content())
                .score(dto.score())
                .user(user)
                .restaurant(restaurant)
                .build();
    }
}
