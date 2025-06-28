package com.example.hackathonbe.global.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // GLOBAL
    INTERNAL_SEVER_ERROR(INTERNAL_SERVER_ERROR, "알 수없는 오류입니다."),

    // AUTH
    AUTH_REQUIRED(UNAUTHORIZED, "로그인이 필요한 서비스입니다."),
    LOGIN_FAILED(UNAUTHORIZED, "아이디 또는 비밀번호가 일치하지 않습니다."),
    USER_NOT_FOUND(NOT_FOUND, "존재하지 않는 사용자입니다."),
    NOT_PERMISSION(FORBIDDEN, "접근 권한이 없습니다."),

    // PAPER
    NO_PAPERS_FOUND(NOT_FOUND, "생성된 페이지가 없습니다."),

    // Follow
    NO_FRIENDS_FOUND(NOT_FOUND, "친구가 없습니다."),
    ALREADY_FOLLOWED_FRIEND(CONFLICT, "이미 팔로우한 친구입니다."),
    NO_RESULT(NOT_FOUND, "해당 아이디를 가진 친구가 없습니다."),

    // Message
    NO_MESSAGES_FOUND(NOT_FOUND, "작성된 메시지가 없습니다."),

    // Notification
    NO_NOTIFICATIONS_FOUND(NOT_FOUND, "알림이 없습니다.");

    private final HttpStatus code;
    private final String message;

}
