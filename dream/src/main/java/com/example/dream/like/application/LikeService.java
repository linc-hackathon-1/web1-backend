package com.example.dream.like.application;

import com.example.dream.like.domain.Like;
import com.example.dream.like.repository.LikeRepository;
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

    public LikeService(LikeRepository likeRepository, VideoRepository videoRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }

    public String clickVideoLike(Long userId, String videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("no video"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("no user"));

        Optional<Like> like = likeRepository.findByUserAndVideo(user, video);
        if (like.isPresent()) {
            video.subLikesCount();
            videoRepository.save(video);
            likeRepository.delete(like.get());
            return "remove";
        } else {
            video.addLikesCount();
            videoRepository.save(video);
            Like newLike= Like.builder()
                    .user(user)
                    .video(video)
                    .build();
            likeRepository.save(newLike);
            return "add";

        }
    }
}
