package com.example.hackathonbe.notification.dto;

import com.example.hackathonbe.notification.entity.AlarmEntity;

import java.time.LocalDateTime;
import java.util.List;

public record GetNotificationResponseDto(List<AlarmEntity> alarmEntityList, LocalDateTime lastCheckAt) {
}
