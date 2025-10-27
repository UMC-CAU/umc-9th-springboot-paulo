package com.example.umc_9th_paulo.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserMyPageDto {
        String nickname;
        Integer points;
        String email;
        Boolean phoneVerified;
        String imageUrl;
    }
}
