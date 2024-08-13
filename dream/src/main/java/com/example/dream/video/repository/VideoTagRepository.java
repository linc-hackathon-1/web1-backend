package com.example.dream.video.repository;

import com.example.dream.video.domain.Video;
import com.example.dream.video.domain.VideoTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoTagRepository extends JpaRepository<VideoTag, Long> {
    List<VideoTag> findVideoTagsByVideo(Video video);
    List<VideoTag> findVideoTagsByTag(String tag);
}
