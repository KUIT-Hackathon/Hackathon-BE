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

    public static NotificationEntity create(Long userId, Long alarmId) {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.userId = userId;
        notificationEntity.alarmId = alarmId;

        return notificationEntity;
    }
}
