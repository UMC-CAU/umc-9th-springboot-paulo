package com.example.umc_9th_paulo.domain.mission.repository;

import com.example.umc_9th_paulo.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select m from Mission m " +
            "join Restaurant rt on m.restaurant.id = rt.id " +
            "join Region ri on rt.region.id = ri.id " +
            "where ri.id =:regionId and m.remainingDuration > 0 and " +
            "m.id not in (select um.mission.id from UserMission um where um.user.id =:userId)")
    Page<Mission> findByRegionAndUserNotIn(@Param("regionId") Long regionId, @Param("userId") Long userId, Pageable pageable);
}
