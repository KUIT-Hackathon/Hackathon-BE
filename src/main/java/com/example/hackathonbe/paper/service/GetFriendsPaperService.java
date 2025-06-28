package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.follow.repository.FollowRepository;
import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.paper.dto.GetFriendsPaperResponseDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFriendsPaperService {
    private final FollowRepository followRepository;
    private final PaperRepository paperRepository;

    public GetFriendsPaperResponseDto get(Long id) {
        List<Long> friendIdsList = followRepository.findAllByFromUserId(id).stream().map(it -> it.getToUserId()).toList();
        if (friendIdsList.isEmpty()) { // 친구가 없으면 에러 내리기
            throw new BusinessException(ErrorCode.NO_FRIENDS_FOUND);
        }

        List<PaperEntity> paperEntityList = paperRepository.findAllByOwnerIn(friendIdsList); // 우선 In 사용해서 가져오게 디자인. 추후 Exists 사용하게 변경할 수도 있음

        return new GetFriendsPaperResponseDto(paperEntityList);
    }
}
