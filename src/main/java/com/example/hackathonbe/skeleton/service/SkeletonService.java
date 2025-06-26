package com.example.hackathonbe.skeleton.service;

import com.example.hackathonbe.skeleton.dto.SkeletonResponseDto;
import com.example.hackathonbe.skeleton.entity.Skeleton;
import com.example.hackathonbe.skeleton.repository.SkeletonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * UseCase 인터페이스를 상속하여 서비스 로직 구현
 * - Input: 컨트롤러에서 요청 데이터를 받을 때 사용
 * - Output: 클라이언트에 응답할 데이터 정의
 * - execute: 로직 정의. 컨트롤러에서 execute 호출
 */

@Service
@RequiredArgsConstructor
public class SkeletonService {
    private final SkeletonRepository skeletonRepository;

    public SkeletonResponseDto getSkeleton(String name) {
        skeletonRepository.save(new Skeleton(name));
        return SkeletonResponseDto.builder()
                .name(name)
                .build();
    }
}
