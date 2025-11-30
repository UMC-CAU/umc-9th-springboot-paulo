package com.example.umc_9th_paulo.domain.review.controller;

import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.global.annotation.CheckPage;
import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewControllerDocs {
    @Operation(
            summary = "유저별 리뷰 확인",
            description = "유저별 가게 리뷰를 조회. 페이지네이션"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<ReviewResponseDto.SearchList> searchReviews(
            @CheckPage @RequestParam Integer page,
            @RequestParam Long userId,
            @RequestParam Long restaurantId
    );
}
