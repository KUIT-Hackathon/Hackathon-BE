package com.example.hackathonbe.notification.dto;

import com.example.hackathonbe.notification.entity.AlarmEntity;

import java.util.List;

public record GetNotificationResponseDto(List<AlarmEntity> alarmEntityList) {
}
