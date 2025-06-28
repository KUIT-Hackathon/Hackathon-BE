package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.message.repository.MessageRepository;
import com.example.hackathonbe.paper.dto.GetSpecificPaperResponseDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetSpecificPaperService {
    private final PaperRepository paperRepository;
    private final MessageRepository messageRepository;

    public GetSpecificPaperResponseDto get(String uuid) {

        PaperEntity paperEntity = paperRepository.findByUuid(uuid);
        Long messageNum = messageRepository.countAllByUuid(uuid);

        return new GetSpecificPaperResponseDto(paperEntity.getUuid(), paperEntity.getTitle(), paperEntity.getPublishDate(), messageNum);
    }
}
