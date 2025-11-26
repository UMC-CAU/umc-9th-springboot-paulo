package com.example.umc_9th_paulo.domain.restaurant.exception.code;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RestaurantSuccessCode implements BaseSuccessCode {

    FOUND(HttpStatus.OK, "RESTAURANT200_1", "식당을 찾았습니다"),
    OK(HttpStatus.OK, "RESTAURANT200_2", "생성 성공");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
