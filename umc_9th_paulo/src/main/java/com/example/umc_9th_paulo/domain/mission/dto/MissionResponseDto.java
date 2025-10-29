package com.example.umc_9th_paulo.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionUserDto {
        String description;
        String reward;
        String restaurant;
        Boolean isSuccess;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionRegionDto {
        Integer finished;
        Long regionId;
        String regionName;
    }
}
