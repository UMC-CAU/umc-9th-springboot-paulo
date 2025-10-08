package com.example.umc_9th_paulo.domain.user.entity;

import com.example.umc_9th_paulo.domain.user.enums.Role;
import com.example.umc_9th_paulo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", length = 100, nullable = false)
    private String nickname;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "status", nullable = false)
    @Builder.Default
    private Boolean status = false;

    @Column(name = "inactived_at")
    private LocalDateTime inactivedAt;
}
