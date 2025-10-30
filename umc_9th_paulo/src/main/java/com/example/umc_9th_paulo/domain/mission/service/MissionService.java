package com.example.umc_9th_paulo.domain.mission.service;


import com.example.umc_9th_paulo.domain.mission.dto.MissionRequestDto;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.mission.repository.MissionRepository;
import com.example.umc_9th_paulo.domain.mission.repository.UserMissionRepository;
import com.example.umc_9th_paulo.domain.restaurant.entity.Region;
import com.example.umc_9th_paulo.domain.restaurant.repository.RegionRepository;
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
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;

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

    @Transactional
    public MissionResponseDto.MissionRegionDto getRegionMission(String regionName, Long userId) {
        Region region = regionRepository.findByName(regionName);
        Integer finished = userMissionRepository.countByIsSuccessAndUserIdAndMission_Restaurant_Region_Id(true, userId, region.getId());
        return MissionResponseDto.MissionRegionDto.builder()
                .regionId(region.getId())
                .finished(finished)
                .regionName(region.getName())
                .build();
    }

    @Transactional
    public Page<MissionResponseDto.MissionRegionCanDto> getRegionMissionCanDo(String regionName, Long userId, Pageable pageable) {
        Region region = regionRepository.findByName(regionName);
        Page<Mission> missions = missionRepository.findByRegionAndUserNotIn(region.getId(), userId, pageable);
        Page<MissionResponseDto.MissionRegionCanDto> missionRegionCanDtos = missions.map(mission -> {
            return MissionResponseDto.MissionRegionCanDto.builder()
                    .missionDescription(mission.getMissionDescription())
                    .missionDuration(mission.getRemainingDuration())
                    .missionReward(mission.getReward())
                    .restaurantName(mission.getRestaurant().getName())
                    .build();
        });

        return missionRegionCanDtos;
    }
}
