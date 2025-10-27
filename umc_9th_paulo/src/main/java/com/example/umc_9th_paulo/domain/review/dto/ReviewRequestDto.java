package com.example.umc_9th_paulo.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDto {

    @Getter
    @Setter
    public static class CreateReview {
        Integer score;
        String content;
        Long userId;
        Long restaurantId;
    }
}
