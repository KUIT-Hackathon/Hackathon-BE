package com.example.hackathonbe.notification.entity;

import com.example.hackathonbe.notification.entity.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public static AlarmEntity create(Type type, String message) {
        AlarmEntity entity = new AlarmEntity();
        entity.type = type;
        entity.message = message;

        return entity;
    }
}
