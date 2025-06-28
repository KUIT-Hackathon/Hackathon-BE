package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.notification.share.AddNotificationAsync;
import com.example.hackathonbe.paper.dto.CreatePaperRequestDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.repository.PaperRepository;
import com.example.hackathonbe.user.entity.UserEntity;
import com.example.hackathonbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreatePaperService {
    private final PaperRepository paperRepository;
    private final AddNotificationAsync addNotificationAsync;
    private final UserRepository userRepository;

    @Transactional
    public void create(CreatePaperRequestDto createPaperRequestDto) {
        PaperEntity entity = PaperEntity.create(
                createPaperRequestDto.getOwner(), createPaperRequestDto.getPublishDate(), createPaperRequestDto.getTitle(), createPaperRequestDto.getVisibilityScope(), createPaperRequestDto.getCategory()
        );
        paperRepository.save(entity);

        UserEntity userEntity = userRepository.findById(createPaperRequestDto.getOwner()).orElseThrow();
        addNotificationAsync.addFriendPaperCreatedNotification(userEntity.getId(), userEntity.getName());
    }
}
