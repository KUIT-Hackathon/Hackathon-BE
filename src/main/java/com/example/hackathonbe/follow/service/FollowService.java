package com.example.hackathonbe.follow.service;

import com.example.hackathonbe.follow.entity.FollowEntity;
import com.example.hackathonbe.follow.repository.FollowRepository;
import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    @Transactional
    public void create(Long fromUserId, Long toUserId) {

        if(followRepository.existsByFromUserIdAndToUserId(fromUserId, toUserId)){
            throw new BusinessException(ErrorCode.ALREADY_FOLLOWED_FRIEND);
        }

        FollowEntity followEntity = FollowEntity.create(fromUserId, toUserId);
        followRepository.save(followEntity);
    }

}
