package com.example.umc_9th_paulo.domain.review.converter;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.review.dto.ReviewRequestDto;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.entity.ReviewPhoto;
import com.example.umc_9th_paulo.domain.user.entity.User;
import org.springframework.data.domain.Page;

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

    public static ReviewResponseDto.SearchList searchList(Page<Review> reviews){
        return ReviewResponseDto.SearchList.builder()
                .list(reviews.getContent().stream()
                        .map(ReviewConverter::searchReview)
                        .toList()
                )
                .listSize(reviews.getSize())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .isFirst(reviews.isFirst())
                .isLast(reviews.isLast())
                .build();
    }

    public static ReviewResponseDto.SearchReviews searchReview(Review review){
        return ReviewResponseDto.SearchReviews.builder()
                .star(review.getScore())
                .reply(review.getReviewReply().getContent())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .images(review.getReviewPhotos().stream()
                        .map(ReviewPhoto::getImageUrl)
                        .toList())
                .build();
    }
}
