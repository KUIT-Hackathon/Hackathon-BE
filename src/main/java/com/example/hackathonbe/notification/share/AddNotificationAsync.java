package com.example.hackathonbe.notification.share;

import com.example.hackathonbe.follow.repository.FollowRepository;
import com.example.hackathonbe.notification.entity.AlarmEntity;
import com.example.hackathonbe.notification.entity.NotificationEntity;
import com.example.hackathonbe.notification.entity.enums.Type;
import com.example.hackathonbe.notification.repository.AlarmRepository;
import com.example.hackathonbe.notification.repository.NotificationRepository;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AddNotificationAsync {
    private final NotificationRepository notificationRepository;
    private final AlarmRepository alarmRepository;
    private final FollowRepository followRepository;
    private final PaperRepository paperRepository;

    // 나를 팔로우하면 알림 내역 추가
    @Async
    public void addFollowNotification(Long userId, String name, String loginId) {
        AlarmEntity alarmEntity = AlarmEntity.create(Type.FOLLOW, name + "(" + loginId + ") 님이 나를 팔로우했어요!");
        AlarmEntity saved = alarmRepository.save(alarmEntity);
        notificationRepository.save(NotificationEntity.create(userId, saved.getId()));
    }

    // 친구의 롤링페이퍼가 추가되었을 때
    @Async
    public void addFriendPaperCreatedNotification(Long toUserId, String name) {
        AlarmEntity alarmEntity = AlarmEntity.create(Type.CREATE, name + "님의 롤링페이퍼가 생겼어요!");
        AlarmEntity saved = alarmRepository.save(alarmEntity);
        followRepository.findAllByToUserId(toUserId)
                .forEach(it -> notificationRepository.save(NotificationEntity.create(it.getFromUserId(), saved.getId())));
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void auto() {
        List<PaperEntity> papers = paperRepository.findAllByPublishDateAndVisibilityScope(
                LocalDate.now(),
                VisibilityScope.PRIVATE
        );

        for (PaperEntity paper : papers) {
            Long ownerId = paper.getOwner();
            if (ownerId != null) {
                AlarmEntity alarmEntity = AlarmEntity.create(
                        Type.OPEN,
                        "나의 롤링페이퍼가 오늘 열렸어요!"
                );
                AlarmEntity saved = alarmRepository.save(alarmEntity);
                notificationRepository.save(NotificationEntity.create(ownerId, saved.getId()));
            }
        }
    }

}
