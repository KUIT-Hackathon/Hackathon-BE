package com.example.hackathonbe.user.dto;

public record UserProfileResponseDto(
        String name,
        int paperCount,
        int followingCount,
        int followerCount
) {}
