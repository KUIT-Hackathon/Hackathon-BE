package com.example.hackathonbe.user.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.user.dto.LoginResponseDto;
import com.example.hackathonbe.user.dto.LoginRequestDto;
import com.example.hackathonbe.user.entity.UserEntity;
import com.example.hackathonbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto request) throws IllegalAccessException {
        UserEntity user = userRepository.findByLoginId(request.getId())
                .orElseThrow(() -> new BusinessException(ErrorCode.LOGIN_FAILED));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new BusinessException(ErrorCode.LOGIN_FAILED);
        }

        return new LoginResponseDto(user.getId());
    }
}