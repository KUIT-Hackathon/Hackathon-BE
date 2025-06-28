package com.example.hackathonbe.paper.dto;

import java.time.LocalDate;

public record GetSpecificPaperResponseDto(
        String uuid,
        String title,
        LocalDate publishDate,
        Long messageNum
) {
}
