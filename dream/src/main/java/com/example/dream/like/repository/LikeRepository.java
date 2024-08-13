package com.example.dream.like.repository;

import com.example.dream.like.domain.Like;
import com.example.dream.user.domain.User;
import com.example.dream.video.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndVideo(User user, Video video);
}
