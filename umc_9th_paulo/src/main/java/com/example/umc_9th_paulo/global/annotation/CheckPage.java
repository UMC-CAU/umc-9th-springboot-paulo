package com.example.umc_9th_paulo.global.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class) // 2단계에서 만들 검증기와 연결
@Target({ ElementType.FIELD, ElementType.PARAMETER }) // 파라미터에 붙일 수 있게 설정
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지 번호는 1 이상이어야 합니다."; // 에러 발생 시 기본 메시지
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
