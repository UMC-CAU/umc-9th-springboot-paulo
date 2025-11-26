package com.example.umc_9th_paulo.domain.restaurant.exception.code;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RestaurantErrorCode implements BaseErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT404_1", "해당 식당이 없습니다"),
    RESTAURANT_ALREADY_EXISTS(HttpStatus.CONFLICT, "RESTAURANT409_1", "이미 존재하는 식당입니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
