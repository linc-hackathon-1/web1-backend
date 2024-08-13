package com.example.dream.video.dto.response;

import com.example.dream.video.dto.VideoPreviewDto;

import java.util.List;

public record VideoListResponse(
        List<VideoPreviewDto> videos
) {
    public static VideoListResponse of(List<VideoPreviewDto> videoPreviewDtos){
        return new VideoListResponse(videoPreviewDtos);
    }
}
