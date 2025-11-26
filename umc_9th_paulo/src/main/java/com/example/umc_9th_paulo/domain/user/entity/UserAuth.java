package com.example.umc_9th_paulo.domain.user.entity;

import com.example.umc_9th_paulo.domain.user.enums.LoginType;
import com.example.umc_9th_paulo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "user_auths")
public class UserAuth extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "login_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private LoginType loginType;
}
