package com.example.umc_9th_paulo.domain.mission.service;

import com.example.umc_9th_paulo.domain.mission.converter.MissionConverter;
import com.example.umc_9th_paulo.domain.mission.dto.MissionResponseDto;
import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.mission.repository.MissionRepository;
import com.example.umc_9th_paulo.domain.mission.repository.UserMissionRepository;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import com.example.umc_9th_paulo.domain.restaurant.exception.RestaurantException;
import com.example.umc_9th_paulo.domain.restaurant.exception.code.RestaurantErrorCode;
import com.example.umc_9th_paulo.domain.restaurant.repository.RestaurantRepository;
import com.example.umc_9th_paulo.domain.user.entity.User;
import com.example.umc_9th_paulo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionCommandService{
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public MissionResponseDto.GetMissionsList getMissionsList(Integer page, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Mission> result = missionRepository.findAllByRestaurant(restaurant, pageRequest);
        return MissionConverter.getMissionsList(result);
        }

    @Override
    @Transactional
    public MissionResponseDto.GetMissionsList getUserDoingMissionsList(Integer page, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));
        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<UserMission> result = userMissionRepository.findByUserAndIsSuccessFalseAndMission_RemainingDurationGreaterThanEqual(user, 0, pageRequest);
        return MissionConverter.getUserMissionsList(result);
    }

    @Transactional
    public MissionResponseDto.GetMissionSliceList getMissionSliceList(Integer page, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantException(RestaurantErrorCode.NOT_FOUND));
        PageRequest pageRequest = PageRequest.of(page,5);
        Slice<Mission> result = missionRepository.findSliceAllByRestaurant(restaurant, pageRequest);
        return MissionConverter.getMissionSliceList(result);
    }
}
