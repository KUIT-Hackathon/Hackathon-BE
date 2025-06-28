package com.example.hackathonbe.follow.service;

import com.example.hackathonbe.follow.dto.FriendsSearchListResponseDto;
import com.example.hackathonbe.follow.entity.FollowEntity;
import com.example.hackathonbe.follow.repository.FollowRepository;
import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional
    public void create(Long fromUserId, Long toUserId) {

        if(followRepository.existsByFromUserIdAndToUserId(fromUserId, toUserId)){
            throw new BusinessException(ErrorCode.ALREADY_FOLLOWED_FRIEND);
        }

        FollowEntity followEntity = FollowEntity.create(fromUserId, toUserId);
        followRepository.save(followEntity);
    }

    public List<FriendsSearchListResponseDto> searchUsersByLoginId(String query) {

        List<FriendsSearchListResponseDto> result = new ArrayList<>();


        result = userRepository.findByLoginIdContaining(query).stream()
                .map(FriendsSearchListResponseDto::from)
                .collect(Collectors.toList());

        if(result.isEmpty()){
            throw new BusinessException(ErrorCode.NO_RESULT);
        }

        return result;
    }

}
