package com.example.umc_9th_paulo.domain.mission.dto;

import lombok.Getter;
import lombok.Setter;

public class MissionRequestDto {
    @Getter
    @Setter
    public static class MissionRegionDto {
        Long userId;
    }
}
