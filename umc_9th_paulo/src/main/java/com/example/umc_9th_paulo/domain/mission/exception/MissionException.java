package com.example.umc_9th_paulo.domain.mission.exception;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseErrorCode;
import com.example.umc_9th_paulo.global.apiPayload.exception.GeneralException;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode message) {
        super(message);
    }
}
