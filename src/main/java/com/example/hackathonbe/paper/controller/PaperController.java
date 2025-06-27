package com.example.hackathonbe.paper.controller;

import com.example.hackathonbe.global.Path.ApiPath;
import com.example.hackathonbe.global.response.ApiResponse;
import com.example.hackathonbe.paper.dto.CreatePaperRequestDto;
import com.example.hackathonbe.paper.dto.CreatePaperResponseDto;
import com.example.hackathonbe.paper.service.CreatePaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPath.PUBLIC)
@RequiredArgsConstructor
public class PaperController {
    private final CreatePaperService createPaperService;

    @PostMapping("/paper/create")
    public ApiResponse<CreatePaperResponseDto> createPaper(
            @RequestHeader(value = "userId", required = true) String userId,
            @RequestBody CreatePaperRequestDto createPaperRequestDto
    ) {
        createPaperService.create(createPaperRequestDto);

        return ApiResponse.ok(new CreatePaperResponseDto());
    }
}
