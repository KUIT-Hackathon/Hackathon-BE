package com.example.hackathonbe.paper.dto;

import com.example.hackathonbe.paper.entity.PaperEntity;

import java.util.List;

public record GetMyPaperResponseDto(List<PaperEntity> paperEntityList) {
}
