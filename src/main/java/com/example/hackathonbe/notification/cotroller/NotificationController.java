package com.example.hackathonbe.notification.cotroller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.config.annotation.RequireLogin;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.notification.dto.GetNotificationResponseDto;
import com.example.hackathonbe.notification.service.GetNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class NotificationController {
    private final GetNotificationService getNotificationService;

    @RequireLogin
    @GetMapping("/notification")
    public ApiResponse<GetNotificationResponseDto> getNotification(
            @RequestHeader(value = "userId", required = true) Long userId
    ) {
        GetNotificationResponseDto getNotificationResponseDto = getNotificationService.get(userId);

        return ApiResponse.ok(getNotificationResponseDto);
    }
}
