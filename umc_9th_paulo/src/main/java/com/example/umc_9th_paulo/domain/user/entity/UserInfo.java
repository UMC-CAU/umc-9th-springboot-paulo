package com.example.umc_9th_paulo.domain.user.entity;

import com.example.umc_9th_paulo.domain.user.enums.Gender;
import com.example.umc_9th_paulo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "user_infos")
public class UserInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.OTHER;

    @Column(name = "birth", nullable = false)
    private LocalDateTime birth;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "image", length = 256)
    private String image;

    @Column(name = "phone_num", nullable = false, length = 100)
    private String phoneNum;

    @Column(name = "phone_num_verification", nullable = false)
    @Builder.Default
    private Boolean phoneNumVerification = false;
}
