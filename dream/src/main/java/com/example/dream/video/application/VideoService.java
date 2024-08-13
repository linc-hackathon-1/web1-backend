package com.example.dream.video.application;

import com.example.dream.province.domain.Province;
import com.example.dream.province.repository.ProvinceRepository;
import com.example.dream.video.domain.Video;
import com.example.dream.video.domain.VideoTag;
import com.example.dream.video.dto.request.VideoUploadRequest;
import com.example.dream.video.dto.response.VideoDetailResponse;
import com.example.dream.video.repository.VideoRepository;
import com.example.dream.video.repository.VideoTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {
    private final VideoRepository videoRepository;
    private final ProvinceRepository provinceRepository;
    private final VideoTagRepository videoTagRepository;

    public VideoService(VideoRepository videoRepository, ProvinceRepository provinceRepository, VideoTagRepository videoTagRepository) {
        this.videoRepository = videoRepository;
        this.provinceRepository = provinceRepository;
        this.videoTagRepository = videoTagRepository;
    }

    public void uploadVideo(Long provinceId, VideoUploadRequest request) {
        Province province = provinceRepository.findById(provinceId)
                .orElseThrow(() -> new IllegalArgumentException("no province"));

        Video video = request.makeVideo(province);
        videoRepository.save(video);

        List<VideoTag> videoTags = request.makeVideoTags(video);
        videoTagRepository.saveAll(videoTags);
    }

    public VideoDetailResponse getVideoDetail(String videoId) {
        Video video;
        if(videoId.equals("random")){
            video = videoRepository.findOneByRandom();
        }
        else{
            video = videoRepository.findById(videoId)
                    .orElseThrow(() -> new IllegalArgumentException("no video"));
        }
        List<VideoTag> videoTags = videoTagRepository.findVideoTagsByVideo(video);
        List<String> tags = videoTags.stream()
                .map(tag -> tag.getTag())
                .collect(Collectors.toList());

        return VideoDetailResponse.of(video, tags);
    }

    public void clearWeekLikesCount() {
        List<Video> all = videoRepository.findAll();
        List<Video> processedVideos = all.stream()
                .map(video -> video.clearWeekLikesCount())
                .collect(Collectors.toList());
        videoRepository.saveAll(processedVideos);
    }
}
