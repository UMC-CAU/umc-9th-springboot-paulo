package com.example.umc_9th_paulo.domain.mission.dto;

import com.example.umc_9th_paulo.domain.review.dto.ReviewResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionRegionCanDto {
        String restaurantName;
        String missionDescription;
        String missionReward;
        Integer missionDuration;
    }

    @Builder
    public record CreateMission(
            Long missionId,
            LocalDateTime createdAt
    ){}

    @Builder
    public record GoUserMission(
            Long userMissionId,
            LocalDateTime createdAt
    ){}

    @Builder
    public record GetMissionsList(
            List<MissionResponseDto.GetMission> list,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record GetMission(
            Long MissionId,
            LocalDateTime createdAt,
            Integer missionDuration,
            String missionDescription,
            String reward
    ){}
}
