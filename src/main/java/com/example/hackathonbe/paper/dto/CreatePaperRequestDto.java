package com.example.hackathonbe.paper.dto;

import com.example.hackathonbe.paper.entity.enums.Category;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreatePaperRequestDto {
    private Long owner;
    private LocalDate publishDate;
    private String title;
    private VisibilityScope visibilityScope;
    private Category category;
}
