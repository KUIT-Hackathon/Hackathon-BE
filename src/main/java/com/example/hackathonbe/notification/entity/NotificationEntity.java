package com.example.hackathonbe.notification.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(columnDefinition = "bigint", nullable = false)
    private Long alarmId;

    @Column(columnDefinition = "bool", nullable = false)
    private boolean is_checked = false;
}
