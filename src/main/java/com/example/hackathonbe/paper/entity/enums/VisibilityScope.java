package com.example.hackathonbe.paper.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VisibilityScope {
    PRIVATE("PRIVATE"),
    PUBLIC("PUBLIC");

    private final String scope;
}
