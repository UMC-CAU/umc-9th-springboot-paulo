package com.example.umc_9th_paulo.domain.review.service;

import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.restaurant.exception.RestaurantException;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
import com.example.umc_9th_paulo.domain.review.converter.ReviewConverter;
import com.example.umc_9th_paulo.domain.review.dto.ReviewRequestDto;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.repository.ReviewRepository;
import com.example.umc_9th_paulo.domain.user.entity.User;
import com.example.umc_9th_paulo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public ReviewResponseDto.CreateReview1 createReview(ReviewRequestDto.CreateReview1 dto) {

        Restaurant restaurant = restaurantRepository.findById(dto.restaurantId()).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));

        //어차피 하드코딩이라 restaurant로 햇습니다
        User user = userRepository.findById(dto.userId()).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));
        Review review = ReviewConverter.toCreateReview(dto, user, restaurant);


        Review savedReview = reviewRepository.save(review);
        return ReviewConverter.toCreateReview(savedReview);
    }
}
