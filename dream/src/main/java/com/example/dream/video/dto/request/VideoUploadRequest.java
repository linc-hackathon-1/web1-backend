package com.example.dream.video.dto.request;

import com.example.dream.province.domain.Province;
import com.example.dream.video.domain.Video;

public record VideoUploadRequest(
        String title,
        String url,
        String description
) {
    public Video toEntity(Province province){
        return Video.builder().
                province(province).
                title(this.title).
                url(this.url).
                description(this.description).
                build();
    }
}
