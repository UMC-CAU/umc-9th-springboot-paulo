package com.example.umc_9th_paulo.domain.mission.entity;

import com.example.umc_9th_paulo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "remaining_duration", nullable = false)
    private Integer remainingDuration;

    @Column(name = "mission_description", nullable = false, length = 1000)
    private String missionDescription;

    @Column(name = "reward", nullable = false, length = 100)
    private String reward;
}
