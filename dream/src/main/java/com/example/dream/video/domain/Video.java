package com.example.dream.video.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private int likesCount;
    private int repliesCount;
    private String description;

    @Builder
    public Video(Long id, String title, String url, int likesCount, int repliesCount, String description) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.likesCount = likesCount;
        this.repliesCount = repliesCount;
        this.description = description;
    }
}
