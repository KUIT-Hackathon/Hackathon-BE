package com.example.hackathonbe.message.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(columnDefinition = "varchar(36)", nullable = false)
    private String uuid;

    @Column(columnDefinition = "varchar(8)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(300)", nullable = false)
    private String content;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public static MessageEntity create(String uuid, String name, String title, String content) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.uuid = uuid;
        messageEntity.name = name;
        messageEntity.title = title;
        messageEntity.content = content;

        return messageEntity;
    }
}
