package com.example.hackathonbe.paper.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    BIRTHDAY("BIRTHDAY"),
    PROMOTION("PROMOTION"),
    GRADUATION("GRADUATION"),
    EMPLOYMENT("EMPLOYMENT"),
    RESIGNATION("RESIGNATION");

    private final String name;
}
