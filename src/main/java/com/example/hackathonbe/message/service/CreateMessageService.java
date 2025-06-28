package com.example.hackathonbe.message.service;

import com.example.hackathonbe.message.dto.CreateMessageRequestDto;
import com.example.hackathonbe.message.entity.MessageEntity;
import com.example.hackathonbe.message.repository.MessageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMessageService {
    private final MessageRepository messageRepository;

    @Transactional
    public void create(CreateMessageRequestDto createMessageRequestDto) {
        MessageEntity messageEntity = MessageEntity.create(
                createMessageRequestDto.getUuid(), createMessageRequestDto.getName(), createMessageRequestDto.getTitle(), createMessageRequestDto.getContent()
        );

        messageRepository.save(messageEntity);
    }
}
