package com.example.umc_9th_paulo.domain.mission.converter;

import com.example.umc_9th_paulo.domain.mission.dto.MissionRequestDto;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.user.entity.User;
import org.springframework.data.domain.Page;

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

    public static MissionResponseDto.GetMissionsList getMissionsList(Page<Mission> missions){
        return MissionResponseDto.GetMissionsList.builder()
                .list(missions.getContent().stream()
                        .map(MissionConverter::getMission)
                        .toList())
                .listSize(missions.getSize())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

    public static MissionResponseDto.GetMission getMission(Mission mission){
        return MissionResponseDto.GetMission.builder()
                .MissionId(mission.getId())
                .missionDuration(mission.getRemainingDuration())
                .missionDescription(mission.getMissionDescription())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
