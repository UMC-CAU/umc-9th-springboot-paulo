package com.example.umc_9th_paulo.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ReviewRequestDto {

    @Getter
    @Setter
    public static class CreateReview {
        Float score;
        String content;
        Long userId;
        Long restaurantId;
    }

    public record CreateReview1(
            Float score,
            String content,
            Long userId,
            Long restaurantId
    ){}
}
