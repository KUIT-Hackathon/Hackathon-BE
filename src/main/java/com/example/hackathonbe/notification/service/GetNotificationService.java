package com.example.hackathonbe.notification.service;

import com.example.hackathonbe.notification.dto.GetNotificationResponseDto;
import com.example.hackathonbe.notification.repository.AlarmRepository;
import com.example.hackathonbe.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetNotificationService {
    private final NotificationRepository notificationRepository;
    private final AlarmRepository alarmRepository;

    public GetNotificationResponseDto get(Long userId) {
        List<Long> notificationIdsList = notificationRepository.findAllByUserId(userId).stream().map(it -> it.getAlarmId()).toList();

        return new GetNotificationResponseDto(alarmRepository.findAllByIdIn(notificationIdsList));
    }
}
