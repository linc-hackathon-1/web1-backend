package com.example.dream.like.presentation;

import com.example.dream.like.application.LikeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/like")
@Tag(name = "좋아요 관련 컨트롤러")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PatchMapping("/video")
    public ResponseEntity<String> clickVideoLike(@RequestParam Long userId, @RequestParam String videoId) {

        String result = likeService.clickVideoLike(userId, videoId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
