package com.example.hackathonbe.skeleton.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.skeleton.dto.SkeletonResponseDto;
import com.example.hackathonbe.skeleton.service.SkeletonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * [요청 매핑 규칙]
 * - 클라이언트 요청은 Service.Input 객체로 변환됩니다.
 * - 모든 응답은 ApiResponse<Service.Output> 또는 ApiResponse<?> 형태로 반환됩니다.
 * - Service.Input과 Service.Output 클래스는 Service 내부에 정의되어 있습니다.
 */

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class SkeletonController {
    private final SkeletonService skeletonService;

    @GetMapping("/skeleton/{name}")
    public ApiResponse<SkeletonResponseDto> getSkeleton(@PathVariable String name) {
        SkeletonResponseDto result = skeletonService.getSkeleton(name);

        return ApiResponse.ok(result);
    }
}
