package com.example.umc_9th_paulo.domain.mission.controller;

import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import com.example.umc_9th_paulo.global.annotation.CheckPage;
import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestParam;

public interface MissionControllerDocs {
    @Operation(
            summary = "가게별 미션 확인",
            description = "가게별 미션을 조회. 페이지네이션"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResponseDto.GetMissionsList> getMissionsList(
            @CheckPage @RequestParam Integer page,
            @RequestParam Long restaurantId
    );

    @Operation(
            summary = "유저별 진행 중인 미션 확인",
            description = "유저별 진행 중인 미션을 조회. 페이지네이션"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResponseDto.GetMissionsList> getUserDoingMissionsList(
            @CheckPage @RequestParam Integer page,
            @RequestParam Long userId
    );
}
