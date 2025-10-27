package com.example.umc_9th_paulo.domain.review.service;

import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
import com.example.umc_9th_paulo.domain.review.dto.ReviewRequestDto;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.repository.ReviewRepository;
import com.example.umc_9th_paulo.domain.user.entity.User;
import com.example.umc_9th_paulo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewResponseDto.CreateReview createReview(ReviewRequestDto.CreateReview dto) {

        Review review = Review.builder()
                .score(dto.getScore())
                .content(dto.getContent())
                .user(userRepository.findById(dto.getUserId()).orElseThrow())
                .restaurant(restaurantRepository.findById(dto.getRestaurantId()).orElseThrow())
                .build();
        reviewRepository.save(review);
        return ReviewResponseDto.CreateReview.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
