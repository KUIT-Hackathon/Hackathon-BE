package com.example.hackathonbe.global.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // AUTH
    AUTH_REQUIRED(BAD_REQUEST, "로그인이 필요한 서비스입니다.");

    private final HttpStatus code;
    private final String message;

}
