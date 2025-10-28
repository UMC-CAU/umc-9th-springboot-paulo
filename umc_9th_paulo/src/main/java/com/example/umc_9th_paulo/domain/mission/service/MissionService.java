package com.example.umc_9th_paulo.domain.mission.service;


import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.mission.repository.UserMissionRepository;
import com.example.umc_9th_paulo.domain.user.entity.User;
import com.example.umc_9th_paulo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Transactional
    public Page<MissionResponseDto.MissionUserDto> MissionUserInfo(Long userId, Boolean finished, Pageable pageable) {
        User user = userRepository.findById(userId).orElse(null);
        Page<UserMission> userMissions = userMissionRepository.findByUserAndIsSuccess(user, finished, pageable);
        Page<MissionResponseDto.MissionUserDto> missionUserDtos = userMissions.map(userMission -> {
            return MissionResponseDto.MissionUserDto.builder()
                    .isSuccess(userMission.getIsSuccess())
                    .restaurant(userMission.getMission().getRestaurant().getName())
                    .description(userMission.getMission().getMissionDescription())
                    .reward(userMission.getMission().getReward())
                    .createdAt(userMission.getCreatedAt())
                    .build();
        });
        return missionUserDtos;
    }
}
