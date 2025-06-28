package com.example.hackathonbe.user.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.user.dto.SignupRequestDto;
import com.example.hackathonbe.user.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class UserController {

    private final SignupService signupService;

    @PostMapping("/auth/signup")
    public ApiResponse<Void> signup(@RequestBody SignupRequestDto request){
        signupService.signup(request);
        return ApiResponse.ok(null);
    }
}
