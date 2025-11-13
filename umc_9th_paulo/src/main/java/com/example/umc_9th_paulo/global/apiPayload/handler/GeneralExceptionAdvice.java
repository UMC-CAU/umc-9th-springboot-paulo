package com.example.umc_9th_paulo.global.apiPayload.handler;

import com.example.umc_9th_paulo.global.apiPayload.ApiResponse;
import com.example.umc_9th_paulo.global.apiPayload.code.BaseErrorCode;
import com.example.umc_9th_paulo.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_9th_paulo.global.apiPayload.exception.GeneralException;
import com.example.umc_9th_paulo.global.discord.DiscordClient;
import com.example.umc_9th_paulo.global.discord.DiscordMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice(basePackages = "com.example.umc_9th_paulo")
public class GeneralExceptionAdvice {

    private final DiscordClient discordClient;
    private final Environment environment;
    public GeneralExceptionAdvice(DiscordClient discordClient, Environment environment) {
        this.discordClient = discordClient;
        this.environment = environment;
    }

    // 애플리케이션에서 발생하는 커스텀 예외를 처리
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Void>> handleException(
            GeneralException ex
    ) {

        return ResponseEntity.status(ex.getCode().getStatus())
                .body(ApiResponse.onFailure(
                                ex.getCode(),
                                null
                        )
                );
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception ex, WebRequest request
    ) {

        if (!Arrays.asList(environment.getActiveProfiles()).contains("local")) {
            sendDiscordAlarm(ex, request);
        }

        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(
                                code,
                                ex.getMessage()
                        )
                );
    }


    private void sendDiscordAlarm(Exception e, WebRequest request) {
        discordClient.sendAlarm(createMessage(e, request));
    }

    private DiscordMessage createMessage(Exception e, WebRequest request) {
        return DiscordMessage.builder()
                .content("# 🚨 에러 발생 비이이이이사아아아앙")
                .embeds(
                        List.of(
                                DiscordMessage.Embed.builder()
                                        .title("ℹ️ 에러 정보")
                                        .description(
                                                "### 🕖 발생 시간\n"
                                                        + LocalDateTime.now()
                                                        + "\n"
                                                        + "### 🔗 요청 URL\n"
                                                        + createRequestFullPath(request)
                                                        + "\n"
                                                        + "### 📄 Stack Trace\n"
                                                        + "```\n"
                                                        + getStackTrace(e).substring(0, 1000)
                                                        + "\n```")
                                        .build()
                        )
                )
                .build();
    }

    private String createRequestFullPath(WebRequest webRequest) {
        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        String fullPath = request.getMethod() + " " + request.getRequestURL();

        String queryString = request.getQueryString();
        if (queryString != null) {
            fullPath += "?" + queryString;
        }

        return fullPath;
    }

    private String getStackTrace(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
