package com.example.hackathonbe.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * API 응답 정의
 */

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;

    public static ErrorResponse from(String message) {
        return new ErrorResponse(message);
    }
}