package com.example.hackathonbe.notification.entity;

import com.example.hackathonbe.notification.entity.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class AlarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String message;

    @Column(columnDefinition = "timestamp", nullable = false)
    private LocalDateTime createdAt;

    public static AlarmEntity create(Type type, String message) {
        AlarmEntity entity = new AlarmEntity();
        entity.type = type;
        entity.message = message;
        entity.createdAt = LocalDateTime.now();

        return entity;
    }
}
