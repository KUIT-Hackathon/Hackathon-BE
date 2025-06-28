package com.example.hackathonbe.paper.dto;

import com.example.hackathonbe.paper.entity.PaperEntity;

import java.util.List;

public record GetFriendsPaperResponseDto(List<PaperEntity> paperEntityList) {
}
