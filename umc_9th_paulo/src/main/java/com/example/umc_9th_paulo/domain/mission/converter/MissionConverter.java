package com.example.umc_9th_paulo.domain.mission.converter;

import com.example.umc_9th_paulo.domain.mission.dto.MissionRequestDto;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.user.entity.User;

public class MissionConverter {
    public static MissionResponseDto.CreateMission createMission(Mission mission){
        return MissionResponseDto.CreateMission.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission createMission(MissionRequestDto.CreateMission dto, Restaurant restaurant){
        return Mission.builder()
                .missionDescription(dto.missionDescription())
                .reward(dto.reward())
                .remainingDuration(dto.missionDuration())
                .restaurant(restaurant)
                .build();
    }

    public static MissionResponseDto.GoUserMission goUserMission(UserMission userMission){
        return MissionResponseDto.GoUserMission.builder()
                .userMissionId(userMission.getId())
                .createdAt(userMission.getCreatedAt())
                .build();
    }

    public static UserMission userMission(User user, Mission mission){
        return UserMission.builder()
                .mission(mission)
                .user(user)
                .isSuccess(false)
                .build();
    }
}
