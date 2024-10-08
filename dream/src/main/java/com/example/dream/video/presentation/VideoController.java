package com.example.dream.video.presentation;

import com.example.dream.video.application.VideoService;
import com.example.dream.video.dto.request.VideoUploadRequest;
import com.example.dream.video.dto.response.VideoDetailResponse;
import com.example.dream.video.dto.response.VideoListResponse;
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
    public ResponseEntity<String> uploadVideo(@PathVariable("provinceId") Long provinceId,
                                                   @RequestBody VideoUploadRequest request) {
        videoService.uploadVideo(provinceId, request);
        return new ResponseEntity<>("success upload video", HttpStatus.OK);
    }

    @GetMapping ("/{videoId}")
    @Operation(description = "영상 정보를 불러온다.")
    public ResponseEntity<VideoDetailResponse> getVideo(@PathVariable("videoId") String videoId) {
        VideoDetailResponse response = videoService.getVideoDetail(videoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping ("/next-video")
    @Operation(description = "영상 정보를 불러온다.")
    public ResponseEntity<String> getRandomVideoId() {
        String response = videoService.getRandomVideoId();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping ("/list/{tag}")
    @Operation(description = "영상 정보를 불러온다.")
    public ResponseEntity<VideoListResponse> getVideoList(@PathVariable("tag") String tag, @RequestParam int page) {
        VideoListResponse response = videoService.getVideoPreviewList(tag, page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping ("/province")
    @Operation(description = "지역 채널에 속한 영상들을 불러온다.")
    public ResponseEntity<VideoListResponse> getProvinceVideos(@RequestParam Long provinceId, @RequestParam int page) {
        VideoListResponse response = videoService.getProvinceVideoPreviews(provinceId, page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
