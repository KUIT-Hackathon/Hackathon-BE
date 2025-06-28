package com.example.hackathonbe.paper.dto;

import java.time.LocalDateTime;

public record GetSpecificPaperResponseDto(
        String uuid,
        String title,
        LocalDateTime publishDate,
        Long messageNum
) {
}
