package com.example.umc_9th_paulo.domain.review.service;

import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;

public interface ReviewCommandService {
    ReviewResponseDto.SearchList searchReviewList(
        Integer page,
        Long restaurantId,
        Long userId
    );
}
