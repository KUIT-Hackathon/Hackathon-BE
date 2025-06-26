package com.example.hackathonbe.global.response;

import lombok.Getter;

/*
 * API 응답 정의
 */

@Getter
public class ApiResponse<T> {
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(data);
    }
}