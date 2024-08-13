package com.example.dream.video.dto.request;

import com.example.dream.province.domain.Province;
import com.example.dream.video.domain.Video;
import com.example.dream.video.domain.VideoTag;

import java.util.List;
import java.util.stream.Collectors;

public record VideoUploadRequest(
        String title,
        String url,
        String description,
        List<String> tags
) {
    public Video makeVideo(Province province){
        return Video.builder().
                province(province).
                title(this.title).
                url(this.url).
                description(this.description).
                build();
    }

    public List<VideoTag> makeVideoTags(Video video){
        return tags.stream()
                .map(tag -> VideoTag.builder()
                        .tag(tag)
                        .video(video)
                        .build())
                .collect(Collectors.toList());
    }
}
