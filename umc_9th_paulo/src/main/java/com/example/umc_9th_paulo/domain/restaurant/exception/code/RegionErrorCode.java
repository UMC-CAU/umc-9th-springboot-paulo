package com.example.umc_9th_paulo.domain.restaurant.exception.code;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RegionErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, "REGION404_1", "해당 지역이 없습니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
