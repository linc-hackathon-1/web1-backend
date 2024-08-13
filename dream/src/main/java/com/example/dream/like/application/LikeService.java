package com.example.dream.like.application;

import com.example.dream.like.domain.Like;
import com.example.dream.like.repository.LikeRepository;
import com.example.dream.province.domain.Province;
import com.example.dream.province.repository.ProvinceRepository;
import com.example.dream.user.domain.User;
import com.example.dream.user.repository.UserRepository;
import com.example.dream.video.domain.Video;
import com.example.dream.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final VideoRepository videoRepository;
    private final UserRepository userRepository;
    private final ProvinceRepository provinceRepository;

    public LikeService(LikeRepository likeRepository, VideoRepository videoRepository, UserRepository userRepository, ProvinceRepository provinceRepository) {
        this.likeRepository = likeRepository;
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
        this.provinceRepository = provinceRepository;
    }

    public String clickVideoLike(Long userId, String videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("no video"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("no user"));

        Optional<Like> like = likeRepository.findByUserAndVideo(user, video);
        if (like.isPresent()) {
            subVideoLikes(video, like);
            subProvinceLikes(video);
            return "remove like";
        } else {
            addVideoLikes(video, user);
            addProvinceLikes(video);
            return "add like";
        }
    }

    private void addProvinceLikes(Video video) {
        Province province = video.getProvince();
        province.addLikesCount();
        provinceRepository.save(province);
    }

    private void addVideoLikes(Video video, User user) {
        video.addLikesCount();
        videoRepository.save(video);
        Like newLike= Like.builder()
                .user(user)
                .video(video)
                .build();
        likeRepository.save(newLike);
    }

    private void subProvinceLikes(Video video) {
        Province province = video.getProvince();
        province.subLikesCount();
        provinceRepository.save(province);
    }

    private void subVideoLikes(Video video, Optional<Like> like) {
        video.subLikesCount();
        videoRepository.save(video);
        likeRepository.delete(like.get());
    }
}
