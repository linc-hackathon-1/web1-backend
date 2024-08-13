package com.example.dream.video.presentation;

import com.example.dream.video.application.VideoService;
import com.example.dream.video.dto.request.VideoUploadRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/video")
@Tag(name = "영상 관련 컨트롤러")
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/{provinceId}")
    @Operation(description = "영상을 추가한다.")
    public ResponseEntity<String> insertIngredient(@PathVariable("provinceId") Long provinceId,
                                                   @RequestBody VideoUploadRequest request) {
        videoService.uploadVideo(provinceId, request);
        return new ResponseEntity<>("success upload video", HttpStatus.OK);
    }
}
