package com.example.umc_9th_paulo.domain.restaurant.exception;

import com.example.umc_9th_paulo.global.apiPayload.code.BaseErrorCode;
import com.example.umc_9th_paulo.global.apiPayload.exception.GeneralException;

public class RestaurantException extends GeneralException {
    public RestaurantException(BaseErrorCode message) {
        super(message);
    }
}