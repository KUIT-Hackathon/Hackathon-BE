package com.example.hackathonbe.user.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.user.dto.LoginRequestDto;
import com.example.hackathonbe.user.dto.LoginResponseDto;
import com.example.hackathonbe.user.dto.SignupRequestDto;
import com.example.hackathonbe.user.service.LoginService;
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
    private final LoginService loginService;

    @PostMapping("/auth/signup")
    public ApiResponse<Void> signup(@RequestBody SignupRequestDto request){
        signupService.signup(request);
        return ApiResponse.ok(null);
    }

    @PostMapping("/auth/login")
    public ApiResponse<LoginResponseDto> login(@RequestBody LoginRequestDto request) throws IllegalAccessException {
        LoginResponseDto response = loginService.login(request);
        return ApiResponse.ok(response);
    }
}
