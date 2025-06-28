package com.example.hackathonbe.paper.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.config.annotation.RequireLogin;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.global.response.EmptyResponseDto;
import com.example.hackathonbe.paper.dto.*;
import com.example.hackathonbe.paper.service.*;
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
    private final GetMessageService getMessageService;
    private final GetSpecificPaperService getSpecificPaperService;

    @RequireLogin
    @PostMapping("/paper")
    public ApiResponse<EmptyResponseDto> createPaper(
            @RequestHeader(value = "userId", required = true) Long userId,
            @RequestBody CreatePaperRequestDto createPaperRequestDto
    ) {
        createPaperService.create(createPaperRequestDto);

        return ApiResponse.ok(new EmptyResponseDto());
    }

    @RequireLogin
    @GetMapping("/paper/my")
    public ApiResponse<GetMyPaperResponseDto> getMyPaper(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        GetMyPaperResponseDto getMyPaperResponseDto = getMyPaperService.get(userId);

        return ApiResponse.ok(getMyPaperResponseDto);
    }

    @RequireLogin
    @GetMapping("/paper/friends")
    public ApiResponse<GetFriendsPaperResponseDto> getFriendsPaper(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        GetFriendsPaperResponseDto getFriendsPaperResponseDto = getFriendsPaperService.get(userId);

        return ApiResponse.ok(getFriendsPaperResponseDto);
    }

    @RequireLogin
    @GetMapping("/paper/public")
    public ApiResponse<GetPublicPaperResponseDto> getPublicPaper(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        GetPublicPaperResponseDto getPublicPaperResponseDto = getPublicPaperService.get();

        return ApiResponse.ok(getPublicPaperResponseDto);
    }

    @GetMapping("/paper/{uuid}/message")
    public ApiResponse<GetMessageResponseDto> getPaperMessage(
            @RequestHeader(value = "userId", required = false) Long userId,
            @PathVariable(value = "uuid") String uuid
    ) {
        GetMessageResponseDto getMessageResponseDto = getMessageService.get(uuid, userId);

        return ApiResponse.ok(getMessageResponseDto);
    }

    @GetMapping("/paper/{uuid}")
    public ApiResponse<GetSpecificPaperResponseDto> getSpecificPaper(
            @RequestHeader(value = "userId", required = false) Long userId,
            @PathVariable(value = "uuid") String uuid
    ) {
        GetSpecificPaperResponseDto getSpecificPaperResponseDto = getSpecificPaperService.get(uuid);

        return ApiResponse.ok(getSpecificPaperResponseDto);
    }
}
