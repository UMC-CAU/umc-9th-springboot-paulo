package com.example.umc_9th_paulo.domain.mission.repository;

import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import com.example.umc_9th_paulo.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
        @EntityGraph(attributePaths = {"restaurant"})
        @Query("select m from Mission m " +
                "where m.restaurant.region.id = :regionId " +
                "and m.remainingDuration > 0 " +
                "and not exists (" +
                "  select 1 from UserMission um " +
                "  where um.user.id = :userId and um.mission.id = m.id" +
                ")")
    Page<Mission> findByRegionAndUserNotIn(@Param("regionId") Long regionId, @Param("userId") Long userId, Pageable pageable);

    Page<Mission> findAllByRestaurant(Restaurant restaurant, Pageable pageable);

    Slice<Mission> findSliceAllByRestaurant(Restaurant restaurant, Pageable pageable);
}
