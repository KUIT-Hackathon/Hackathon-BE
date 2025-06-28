package com.example.hackathonbe.user.service;

import com.example.hackathonbe.follow.repository.FollowRepository;
import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.paper.repository.PaperRepository;
import com.example.hackathonbe.user.dto.UserProfileResponseDto;
import com.example.hackathonbe.user.entity.UserEntity;
import com.example.hackathonbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;
    private final PaperRepository paperRepository;
    private final FollowRepository followRepository;

    @Transactional(readOnly = true)
    public UserProfileResponseDto getProfile(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        int paperCount = paperRepository.findAllByOwner(userId).size();
        int followingCount = (int) followRepository.countByFromUserId(userId);
        int followerCount = (int) followRepository.countByToUserId(userId);

        return new UserProfileResponseDto(
                user.getName(),
                paperCount,
                followingCount,
                followerCount
        );
    }
}
