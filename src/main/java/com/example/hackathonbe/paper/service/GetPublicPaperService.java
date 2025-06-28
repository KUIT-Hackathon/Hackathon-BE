package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.paper.dto.GetPublicPaperResponseDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPublicPaperService {
    private final PaperRepository paperRepository;

    public GetPublicPaperResponseDto get() {
        List<PaperEntity> paperEntity = paperRepository.findAllByVisibilityScope(VisibilityScope.PUBLIC);
        if (paperEntity.isEmpty()) { // 조회 결과가 없는 경우에 에러 내림
            throw new BusinessException(ErrorCode.NO_PAPERS_FOUND);
        }

        return new GetPublicPaperResponseDto(paperEntity);
    }
}
