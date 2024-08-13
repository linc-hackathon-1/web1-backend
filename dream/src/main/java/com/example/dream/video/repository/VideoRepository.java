package com.example.dream.video.repository;

import com.example.dream.video.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
    @Query(value = "SELECT * FROM videos ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Video findOneByRandom();
}
