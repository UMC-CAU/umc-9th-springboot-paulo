package com.example.umc_9th_paulo.domain.mission.service;


import com.example.umc_9th_paulo.domain.mission.converter.MissionConverter;
import com.example.umc_9th_paulo.domain.mission.dto.MissionRequestDto;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.mission.exception.MissionException;
import com.example.umc_9th_paulo.domain.mission.exception.code.MissionErrorCode;
import com.example.umc_9th_paulo.domain.mission.repository.MissionRepository;
import com.example.umc_9th_paulo.domain.mission.repository.UserMissionRepository;
import com.example.umc_9th_paulo.domain.restaurant.entity.Region;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.restaurant.exception.RestaurantException;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc_9th_paulo.domain.restaurant.repository.RegionRepository;
import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
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
    private final RestaurantRepository restaurantRepository;

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

    @Transactional
    public MissionResponseDto.CreateMission createMission(MissionRequestDto.CreateMission dto){
        Restaurant restaurant = restaurantRepository.findById(dto.restaurantId()).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));
        Mission mission = MissionConverter.createMission(dto, restaurant);
        Mission savedMission = missionRepository.save(mission);
        return MissionConverter.createMission(savedMission);
    }

    @Transactional
    public MissionResponseDto.GoUserMission goUserMission(MissionRequestDto.GoUserMission dto){
        User user = userRepository.findById(dto.userId()).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));
        Mission mission = missionRepository.findById(dto.missionId()).orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));
        UserMission userMission = MissionConverter.userMission(user, mission);
        UserMission savedUserMission = userMissionRepository.save(userMission);

        return MissionConverter.goUserMission(savedUserMission);
    }
}
