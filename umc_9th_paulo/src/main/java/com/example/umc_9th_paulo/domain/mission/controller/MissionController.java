package com.example.umc_9th_paulo.domain.mission.controller;

import com.example.umc_9th_paulo.domain.mission.dto.MissionRequestDto;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.service.MissionService;
import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import com.example.umc_9th_paulo.global.apiPayload.code.BaseSuccessCode;
import com.example.umc_9th_paulo.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/users/{userId}")
    public ApiResponse<Page<MissionResponseDto.MissionUserDto>> getMissionUser(@PathVariable Long userId, @RequestParam("finished") Boolean finished,
                                                                              @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        return ApiResponse.onSuccess(GeneralSuccessCode._OK, missionService.MissionUserInfo(userId, finished, pageable)) ;
    }

    @GetMapping("/regions/{regionName}/finished")
    public ApiResponse<MissionResponseDto.MissionRegionDto> countMissionRegion(@PathVariable String regionName,
                                                                  @RequestParam Long userId) {
        return ApiResponse.onSuccess(GeneralSuccessCode._OK, missionService.getRegionMission(regionName, userId));
    }

    @GetMapping("/regions/{regionName}")
    public ApiResponse<Page<MissionResponseDto.MissionRegionCanDto>> regionCanDto(@PathVariable String regionName,
                                                                     @RequestParam Long userId,
                                                                     @PageableDefault(size = 10, sort = "remainingDuration") Pageable pageable) {
        return ApiResponse.onSuccess(GeneralSuccessCode._OK,missionService.getRegionMissionCanDo(regionName, userId, pageable));
    }
}
