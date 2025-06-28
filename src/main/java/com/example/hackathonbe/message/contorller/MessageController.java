package com.example.hackathonbe.message.contorller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.global.response.EmptyResponseDto;
import com.example.hackathonbe.message.dto.CreateMessageRequestDto;
import com.example.hackathonbe.message.service.CreateMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class MessageController {
    private final CreateMessageService createMessageService;

    @PostMapping("/message")
    public ApiResponse<EmptyResponseDto> createMessage(
            @RequestBody CreateMessageRequestDto createMessageRequestDto
    ) {
        createMessageService.create(createMessageRequestDto);

        return ApiResponse.ok(new EmptyResponseDto());
    }
}
