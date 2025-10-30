package com.example.umc_9th_paulo.domain.mission.repository;

import com.example.umc_9th_paulo.domain.mission.entity.UserMission;
import com.example.umc_9th_paulo.domain.restaurant.entity.Region;
import com.example.umc_9th_paulo.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Page<UserMission> findByUserAndIsSuccess(User user, Boolean isSuccess, Pageable pageable);

    Integer countByIsSuccessAndUserIdAndMission_Restaurant_Region_Id(Boolean isSuccess, Long userId, Long regionId);
}
