package com.example.hackathonbe.global.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // AUTH
    AUTH_REQUIRED(BAD_REQUEST, "로그인이 필요한 서비스입니다."),

    // PAPER
    NO_PAPERS_FOUND(BAD_REQUEST, "생성된 페이지가 없습니다."),

    // Follow
    NO_FRIENDS_FOUND(BAD_REQUEST, "친구가 없습니다."),
    ALREADY_FOLLOWED_FRIEND(BAD_REQUEST, "이미 팔로우한 친구입니다."),

    // Message
    NO_MESSAGES_FOUND(BAD_REQUEST, "작성된 메시지가 없습니다.");

    private final HttpStatus code;
    private final String message;

}
