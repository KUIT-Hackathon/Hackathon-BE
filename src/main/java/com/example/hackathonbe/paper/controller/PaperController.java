package com.example.hackathonbe.paper.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.config.annotation.RequireLogin;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.paper.dto.*;
import com.example.hackathonbe.paper.service.CreatePaperService;
import com.example.hackathonbe.paper.service.GetFriendsPaperService;
import com.example.hackathonbe.paper.service.GetMyPaperService;
import com.example.hackathonbe.paper.service.GetPublicPaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class PaperController {
    private final CreatePaperService createPaperService;
    private final GetMyPaperService getMyPaperService;
    private final GetFriendsPaperService getFriendsPaperService;
    private final GetPublicPaperService getPublicPaperService;

    @RequireLogin
    @PostMapping("/paper")
    public ApiResponse<CreatePaperResponseDto> createPaper(
            @RequestHeader(value = "userId", required = true) Long userId,
            @RequestBody CreatePaperRequestDto createPaperRequestDto
    ) {
        createPaperService.create(createPaperRequestDto);

        return ApiResponse.ok(new CreatePaperResponseDto());
    }

    @GetMapping("/paper/my")
    public ApiResponse<GetMyPaperResponseDto> getMyPaper(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        GetMyPaperResponseDto getMyPaperResponseDto = getMyPaperService.get(userId);

        return ApiResponse.ok(getMyPaperResponseDto);
    }

    @GetMapping("/paper/friends")
    public ApiResponse<GetFriendsPaperResponseDto> getFriendsPaper(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        GetFriendsPaperResponseDto getFriendsPaperResponseDto = getFriendsPaperService.get(userId);

        return ApiResponse.ok(getFriendsPaperResponseDto);
    }

    @GetMapping("/paper/public")
    public ApiResponse<GetPublicPaperResponseDto> getPublicPaper() {
        GetPublicPaperResponseDto getPublicPaperResponseDto = getPublicPaperService.get();

        return ApiResponse.ok(getPublicPaperResponseDto);
    }
}
