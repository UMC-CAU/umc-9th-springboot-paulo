package com.example.umc_9th_paulo.domain.review.controller;

import com.example.umc_9th_paulo.domain.review.dto.ReviewRequestDto;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.domain.review.entity.Review;
import com.example.umc_9th_paulo.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc_9th_paulo.domain.review.service.ReviewQueryService;
import com.example.umc_9th_paulo.domain.review.service.ReviewService;
import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import com.example.umc_9th_paulo.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    //QueryDsl
    private final ReviewQueryService reviewQueryService;

    @PostMapping
    @Operation(summary = "리뷰 등록 API")
    public ApiResponse<ReviewResponseDto.CreateReview1>createReview(@RequestBody ReviewRequestDto.CreateReview1 dto) {
        return ApiResponse.onSuccess(ReviewSuccessCode.CREATED, reviewService.createReview(dto));
    }

    @GetMapping
    @Operation(summary = "리뷰 조회 API ( QueryDsl 사용 )")
    public ApiResponse<List<ReviewResponseDto.searchReview>> getUserReviewList(
                                            @RequestParam(value = "restaurantName", required = false) String restaurantName,
                                            @RequestParam(value = "star", required = false) Float star,
                                            //UserId는 임시 사용
                                            @RequestParam(value = "userId") Long userId,
                                            @RequestParam(value = "type") Integer type
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode._OK, reviewQueryService.searchReview(restaurantName, star, userId, type));
    }

}

