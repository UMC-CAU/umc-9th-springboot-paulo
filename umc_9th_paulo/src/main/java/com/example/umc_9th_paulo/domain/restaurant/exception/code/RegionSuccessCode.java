package com.example.umc_9th_paulo.domain.restaurant.exception.code;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RegionSuccessCode implements BaseSuccessCode {
    FOUND(HttpStatus.OK, "REGION200_1", "지역을 찾았습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
