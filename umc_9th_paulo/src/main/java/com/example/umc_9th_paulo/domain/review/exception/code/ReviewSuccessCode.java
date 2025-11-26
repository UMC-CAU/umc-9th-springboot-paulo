package com.example.umc_9th_paulo.domain.review.exception.code;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {

    CREATED(HttpStatus.CREATED, "REVIEW201_1", "생성");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
