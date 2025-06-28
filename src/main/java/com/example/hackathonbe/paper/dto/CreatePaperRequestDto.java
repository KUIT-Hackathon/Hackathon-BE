package com.example.hackathonbe.paper.dto;

import com.example.hackathonbe.paper.entity.enums.Category;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import jakarta.annotation.Nullable;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePaperRequestDto {
    @Nullable
    private Long owner;
    private LocalDateTime publishDate;
    private String title;
    private VisibilityScope visibilityScope;
    private Category category;
}
