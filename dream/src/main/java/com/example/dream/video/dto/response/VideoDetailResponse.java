package com.example.dream.video.dto.response;

import com.example.dream.province.domain.Province;
import com.example.dream.video.domain.Video;

public record VideoDetailResponse(
        String id,
        Province province,
        String title,
        String url,
        int likesCount,
        int repliesCount,
        String description
) {
    public static VideoDetailResponse of(Video video){
        return new VideoDetailResponse(
                video.getId(),
                video.getProvince(),
                video.getTitle(),
                video.getUrl(),
                video.getLikesCount(),
                video.getRepliesCount(),
                video.getDescription()
        );
    }
}
