package com.example.umc_9th_paulo.domain.review.dto;

import com.example.umc_9th_paulo.domain.review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDto {

    @Builder
    public record SearchList(
            List<SearchReviews> list,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record SearchReviews(
            String restaurantName,
            Float star,
            String content,
            List<String> images,
            LocalDateTime createdAt,
            String reply
    ){}

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReview {
        Long reviewId;
        LocalDateTime createdAt;
    }

    @Builder
    public record CreateReview1(
            Long reviewId,
            LocalDateTime createdAt
    ){}


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class searchReview {
        String restaurantName;
        Float star;
        String content;
        List<String> images;
    }
}
