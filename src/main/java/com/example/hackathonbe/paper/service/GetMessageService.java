package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.message.entity.MessageEntity;
import com.example.hackathonbe.message.repository.MessageRepository;
import com.example.hackathonbe.paper.dto.GetMessageResponseDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMessageService {
    private final MessageRepository messageRepository;
    private final PaperRepository paperRepository;

    public GetMessageResponseDto get(String uuid, Long userId) {
        List<MessageEntity> messageEntityList = messageRepository.findAllByUuid(uuid);
        PaperEntity paperEntity = paperRepository.findByUuid(uuid);

        if(paperEntity.getVisibilityScope() == VisibilityScope.PRIVATE && userId == null){
            throw new BusinessException(ErrorCode.NOT_PERMISSION);
        }
        if(paperEntity.getVisibilityScope() == VisibilityScope.PRIVATE && !(paperEntity.getOwner().equals(userId))){
            throw new BusinessException(ErrorCode.NOT_PERMISSION);
        }

        if (messageEntityList.isEmpty()) { // 메시지가 없으면 에러 내리기
            throw new BusinessException(ErrorCode.NO_MESSAGES_FOUND);
        }

        return new GetMessageResponseDto(messageEntityList);
    }
}
