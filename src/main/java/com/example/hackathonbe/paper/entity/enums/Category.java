package com.example.hackathonbe.paper.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    BIRTHDAY("BIRTHDAY"),
    FINISH("FINISH");

    private final String name;
}
