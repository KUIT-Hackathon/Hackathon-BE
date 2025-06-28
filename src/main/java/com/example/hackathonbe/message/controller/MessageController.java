package com.example.hackathonbe.message.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.global.response.EmptyResponseDto;
import com.example.hackathonbe.message.dto.CreateMessageRequestDto;
import com.example.hackathonbe.message.service.CreateMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class MessageController {
    private final CreateMessageService createMessageService;

    @PostMapping("/message")
    public ApiResponse<EmptyResponseDto> createMessage(
            @RequestHeader(value = "userId", required = false) Long userId,
            @RequestBody CreateMessageRequestDto createMessageRequestDto
    ) {
        createMessageService.create(createMessageRequestDto);

        return ApiResponse.ok(new EmptyResponseDto());
    }
}
