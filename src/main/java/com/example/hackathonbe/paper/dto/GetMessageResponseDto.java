package com.example.hackathonbe.paper.dto;

import com.example.hackathonbe.message.entity.MessageEntity;

import java.util.List;

public record GetMessageResponseDto(List<MessageEntity> messageEntityList) {
}
