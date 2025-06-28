package com.example.hackathonbe.follow.dto;

import com.example.hackathonbe.user.entity.UserEntity;

public record FriendsSearchListResponseDto(
        Long id,
        String name,
        String loginId
) {
    public static FriendsSearchListResponseDto from(UserEntity entity) {
        return new FriendsSearchListResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getLoginId()
        );
    }
}
