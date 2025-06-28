package com.example.hackathonbe.message.dto;

import lombok.Getter;

@Getter
public class CreateMessageRequestDto {
    private String uuid;
    private String name;
    private String title;
    private String content;
}
