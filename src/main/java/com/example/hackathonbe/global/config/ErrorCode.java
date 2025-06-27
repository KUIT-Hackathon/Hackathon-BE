package com.example.hackathonbe.global.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // USER
    AUTH_NOT_FOUND(BAD_REQUEST, "존재하지 않는 유저입니다.");

    private final HttpStatus code;
    private final String message;

}
