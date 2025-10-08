package com.example.umc_9th_paulo.domain.restaurant.entity;

import com.example.umc_9th_paulo.domain.restaurant.enums.ResType;
import com.example.umc_9th_paulo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "restaurant_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ResType restaurantType;

    @Column(name = "star", nullable = false)
    private Integer star;

    @Column(name = "description", length = 1000, nullable = false)
    private String description;
}