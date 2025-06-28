package com.example.hackathonbe.paper.service;

import com.example.hackathonbe.global.config.BusinessException;
import com.example.hackathonbe.global.config.ErrorCode;
import com.example.hackathonbe.paper.dto.GetMyPaperResponseDto;
import com.example.hackathonbe.paper.entity.PaperEntity;
import com.example.hackathonbe.paper.entity.enums.VisibilityScope;
import com.example.hackathonbe.paper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMyPaperService {
    private final PaperRepository paperRepository;

    public GetMyPaperResponseDto get(Long userId) {
        List<PaperEntity> paperEntityList = paperRepository.findAllByOwner(userId).stream()
                .filter(it -> VisibilityScope.PRIVATE.equals(it.getVisibilityScope()))
                .collect(Collectors.toList()); // VisibilityScope 가 PRIVATE 인 것만 보여주기
        if (paperEntityList.isEmpty()) { // 조회 결과가 없는 경우에 에러 내림
            throw new BusinessException(ErrorCode.NO_PAPERS_FOUND);
        }

        return new GetMyPaperResponseDto(paperEntityList);
    }
}
