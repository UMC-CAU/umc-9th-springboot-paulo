package com.example.umc_9th_paulo.domain.review.exception;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseErrorCode;
import com.example.umc_9th_paulo.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode message) {
        super(message);
    }
}
