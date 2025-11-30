package com.example.umc_9th_paulo.domain.mission.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

public class MissionRequestDto {
    @Getter
    @Setter
    public static class MissionRegionDto {
        Long userId;
    }

    public record CreateMission(
            Integer missionDuration,
            String missionDescription,
            String reward,
            Long restaurantId
    ){}

    public record GoUserMission(
            Long missionId,
            Long userId
    ){}
}
