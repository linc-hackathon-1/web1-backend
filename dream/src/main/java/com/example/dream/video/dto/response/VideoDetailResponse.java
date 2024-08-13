package com.example.dream.video.dto.response;

import com.example.dream.province.dto.ProvinceShortResponse;
import com.example.dream.video.domain.Video;

import java.util.List;

public record VideoDetailResponse(
        String id,
        ProvinceShortResponse province,
        String title,
        String url,
        int likesCount,
        int repliesCount,
        String description,
        List<String> tags
) {
    public static VideoDetailResponse of(Video video, List<String> tags){
        return new VideoDetailResponse(
                video.getId(),
                ProvinceShortResponse.of(video.getProvince()),
                video.getTitle(),
                video.getUrl(),
                video.getLikesCount(),
                video.getRepliesCount(),
                video.getDescription(),
                tags
        );
    }
}
