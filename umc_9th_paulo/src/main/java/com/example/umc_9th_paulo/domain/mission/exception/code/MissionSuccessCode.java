package com.example.umc_9th_paulo.domain.mission.exception.code;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    CREATE(HttpStatus.CREATED,"MISSION201_1", "미션 생성 성공"),
    FOUND(HttpStatus.FOUND, "MISSION200_1", "미션 조회 성공");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
