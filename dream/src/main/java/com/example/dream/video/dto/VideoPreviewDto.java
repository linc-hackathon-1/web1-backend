package com.example.dream.video.dto;

import com.example.dream.video.domain.Video;

public record VideoPreviewDto(
        String id,
        String name,
        String url,
        int likes
) {
    public static VideoPreviewDto of(Video video){
        return new VideoPreviewDto(
                video.getId(),
                video.getTitle(),
                video.getUrl(),
                video.getLikesCount()
        );
    }
}
