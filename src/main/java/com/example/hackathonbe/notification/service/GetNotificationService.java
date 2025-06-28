package com.example.hackathonbe.notification.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.notification.dto.GetNotificationResponseDto;
import com.example.hackathonbe.notification.repository.AlarmRepository;
import com.example.hackathonbe.notification.repository.NotificationRepository;
import com.example.hackathonbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetNotificationService {
    private final NotificationRepository notificationRepository;
    private final AlarmRepository alarmRepository;
    private final UserRepository userRepository;

    public GetNotificationResponseDto get(Long userId) {
        List<Long> notificationIdsList = notificationRepository.findAllByUserId(userId).stream().map(it -> it.getAlarmId()).toList();
        if (notificationIdsList.isEmpty()) { // 유저에게 보여줄 알림이 없으면 에러 내림
            throw new BusinessException(ErrorCode.NO_NOTIFICATIONS_FOUND);
        }

        LocalDate lastCheckedAt = userRepository.findById(userId).orElseThrow().getLastCheckedAt();
        return new GetNotificationResponseDto(alarmRepository.findAllByIdIn(notificationIdsList), lastCheckedAt);
    }
}
