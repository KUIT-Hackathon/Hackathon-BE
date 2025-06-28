package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.paper.dto.CreatePaperRequestDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePaperService {

    private final PaperRepository paperRepository;

    public void create(CreatePaperRequestDto createPaperRequestDto) {
        PaperEntity entity = PaperEntity.create(
                createPaperRequestDto.getOwner(), createPaperRequestDto.getPublishDate(), createPaperRequestDto.getTitle(), createPaperRequestDto.getVisibilityScope(), createPaperRequestDto.getCategory()
        );
        paperRepository.save(entity);
    }
}
