package com.example.hackathonbe.user.service;

import com.example.hackathonbe.user.dto.SignupRequestDto;
import com.example.hackathonbe.user.entity.UserEntity;
import com.example.hackathonbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;

    public void signup(SignupRequestDto request){
        UserEntity user = new UserEntity(
                request.getName(),
                request.getId(),
                request.getPassword()
        );

        userRepository.save(user);
    }
}
