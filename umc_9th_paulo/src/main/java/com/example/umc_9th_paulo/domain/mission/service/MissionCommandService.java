package com.example.umc_9th_paulo.domain.mission.service;

import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;

public interface MissionCommandService {
    MissionResponseDto.GetMissionsList getMissionsList(Integer page, Long restaurantId);

    MissionResponseDto.GetMissionsList getUserDoingMissionsList(Integer page, Long userId);
}
