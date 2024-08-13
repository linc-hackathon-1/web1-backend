package com.example.dream.video.application;

import com.example.dream.province.domain.Province;
import com.example.dream.province.repository.ProvinceRepository;
import com.example.dream.video.domain.Video;
import com.example.dream.video.dto.request.VideoUploadRequest;
import com.example.dream.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private final VideoRepository videoRepository;
    private final ProvinceRepository provinceRepository;

    public VideoService(VideoRepository videoRepository, ProvinceRepository provinceRepository) {
        this.videoRepository = videoRepository;
        this.provinceRepository = provinceRepository;
    }

    public void uploadVideo(Long provinceId, VideoUploadRequest request) {
        Province province = provinceRepository.findById(provinceId)
                .orElseThrow(() -> new IllegalArgumentException("no province"));

        Video video = request.toEntity(province);

        videoRepository.save(video);
    }
}
