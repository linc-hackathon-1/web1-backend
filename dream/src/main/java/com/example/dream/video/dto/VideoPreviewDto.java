package com.example.dream.video.dto;

import com.example.dream.video.domain.Video;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<VideoPreviewDto> of(List<Video> videos){
        return videos.stream()
                .map(VideoPreviewDto::of)
                .collect(Collectors.toList());
    }
}
