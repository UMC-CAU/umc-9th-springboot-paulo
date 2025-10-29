package com.example.umc_9th_paulo.domain.restaurant.repository;

import com.example.umc_9th_paulo.domain.restaurant.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByName(String name);
}
