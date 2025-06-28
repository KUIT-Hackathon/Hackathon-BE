package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.message.entity.MessageEntity;
import com.example.hackathonbe.message.repository.MessageRepository;
import com.example.hackathonbe.paper.dto.GetMessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMessageService {
    private final MessageRepository messageRepository;

    public GetMessageResponseDto get(String uuid) {
        List<MessageEntity> messageEntityList = messageRepository.findAllByUuid(uuid);
        if (messageEntityList.isEmpty()) { // 메시지가 없으면 에러 내리기
            throw new BusinessException(ErrorCode.NO_MESSAGES_FOUND);
        }

        return new GetMessageResponseDto(messageEntityList);
    }
}
