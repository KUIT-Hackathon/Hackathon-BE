package com.example.hackathonbe.follow.service;

import com.example.hackathonbe.follow.dto.FriendsSearchListResponseDto;
import com.example.hackathonbe.follow.entity.FollowEntity;
import com.example.hackathonbe.follow.repository.FollowRepository;
import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.user.entity.UserEntity;
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

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public List<FriendsSearchListResponseDto> getFollowingList(Long userId, String query) {
        List<FriendsSearchListResponseDto> result = followRepository.findAllByFromUserId(userId).stream()
                .map(follow -> {
                    Long friendUserId = follow.getToUserId();
                    UserEntity friend = userRepository.findById(friendUserId)
                            .orElseThrow(() -> new BusinessException(ErrorCode.INTERNAL_SEVER_ERROR));
                    return FriendsSearchListResponseDto.from(friend);
                })
                .filter(dto -> query == null || dto.name().contains(query))
                .toList();

        if (result.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_FRIENDS_FOUND);
        }

        return result;
    }



    @Transactional(readOnly = true)
    public List<FriendsSearchListResponseDto> getFollowerList(Long userId) {
        List<FriendsSearchListResponseDto> result = followRepository.findAllByToUserId(userId).stream()
                .map(follow -> {
                    Long followerUserId = follow.getFromUserId();
                    UserEntity follower = userRepository.findById(followerUserId)
                            .orElseThrow(() -> new BusinessException(ErrorCode.INTERNAL_SEVER_ERROR));
                    return FriendsSearchListResponseDto.from(follower);
                })
                .toList();

        if (result.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_FRIENDS_FOUND);
        }

        return result;
    }


}
