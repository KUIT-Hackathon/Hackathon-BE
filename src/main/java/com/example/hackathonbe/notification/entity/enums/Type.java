package com.example.hackathonbe.notification.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    FOLLOW("FOLLOW"),
    CREATE("CREATE"),
    OPEN("OPEN");

    private final String type;
}
