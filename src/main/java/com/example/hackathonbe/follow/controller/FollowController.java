package com.example.hackathonbe.follow.controller;

import com.example.hackathonbe.follow.dto.FriendsSearchListResponseDto;
import com.example.hackathonbe.follow.service.FollowService;
import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.config.annotation.RequireLogin;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.global.response.EmptyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;

    @RequireLogin
    @PostMapping("/user/follow")
    public ApiResponse<EmptyResponseDto> createPaper(
            @RequestHeader(value = "userId", required = true) Long userId,
            @RequestParam(required = true) Long friendId
    ) {
        followService.create(userId, friendId);
        return ApiResponse.ok(new EmptyResponseDto());
    }

    @RequireLogin
    @GetMapping("/user/search")
    public ApiResponse<List<FriendsSearchListResponseDto>> searchUsers(
            @RequestHeader(value = "userId") Long userId,
            @RequestParam String query
    ) {
        List<FriendsSearchListResponseDto> result = followService.searchUsersByLoginId(userId, query);
        return ApiResponse.ok(result);
    }

    @RequireLogin
    @GetMapping("/user/following")
    public ApiResponse<List<FriendsSearchListResponseDto>> getFollowing(
            @RequestHeader(value = "userId") Long userId,
            @RequestParam(required = false) String query
    ) {
        return ApiResponse.ok(followService.getFollowingList(userId, query));
    }
    @RequireLogin
    @GetMapping("/user/follower")
    public ApiResponse<List<FriendsSearchListResponseDto>> getFollower(
            @RequestHeader(value = "userId") Long userId

    ) {
        return ApiResponse.ok(followService.getFollowerList(userId));
    }


}
