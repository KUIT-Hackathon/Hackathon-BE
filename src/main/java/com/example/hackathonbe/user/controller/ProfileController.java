package com.example.hackathonbe.user.controller;

import com.example.hackathonbe.follow.dto.FriendsSearchListResponseDto;
import com.example.hackathonbe.follow.service.FollowService;
import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.config.annotation.RequireLogin;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.global.response.EmptyResponseDto;
import com.example.hackathonbe.user.dto.UserProfileResponseDto;
import com.example.hackathonbe.user.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @RequireLogin
    @GetMapping("/user/profile")
    public ApiResponse<UserProfileResponseDto> getProfile(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        UserProfileResponseDto profile = profileService.getProfile(userId);
        return ApiResponse.ok(profile);
    }
}
