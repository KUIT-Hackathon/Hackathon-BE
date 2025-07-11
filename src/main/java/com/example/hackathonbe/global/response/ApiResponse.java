package com.example.hackathonbe.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * API 응답 정의
 */

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(data);
    }
}