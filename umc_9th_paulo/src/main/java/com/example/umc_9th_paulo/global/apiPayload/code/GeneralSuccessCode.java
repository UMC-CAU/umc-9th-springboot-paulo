package com.example.umc_9th_paulo.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {
    _OK(HttpStatus.OK,
            "COMMON200",
            "성공입니다"),
    _CREATED(HttpStatus.CREATED,
            "COMMON201",
            "리소스 생성 성공"),
    _NO_CONTENT(HttpStatus.NO_CONTENT,
            "COMMON204",
            "요청 성공, 반환 없음");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
