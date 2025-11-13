package com.example.umc_9th_paulo.domain.user.controller;

import com.example.umc_9th_paulo.domain.user.dto.UserResponseDto;
import com.example.umc_9th_paulo.domain.user.service.UserService;
import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import com.example.umc_9th_paulo.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ApiResponse.onSuccess(GeneralSuccessCode._NO_CONTENT,"사용자 ID: " + userId + "가 성공적으로 삭제되었습니다.");
    }

    @GetMapping("/mypage/{userId}")
    public ApiResponse<UserResponseDto.UserMyPageDto> getUserMyPage(@PathVariable Long userId){
        return ApiResponse.onSuccess(GeneralSuccessCode._OK, userService.getUserMyPage(userId));
    }

    @GetMapping("/test/npe") // 테스트용 임시 URL
    public String testNpe() {
        // 1. 일부러 null 객체를 만듭니다.
        String s = null;

        // 2. null 객체의 메소드를 호출하여 NullPointerException을 발생시킵니다.
        s.length(); // <-- 여기서 500 에러 발생!

        return "이 메시지는 절대 반환되지 않습니다.";
    }
}
