package com.example.dream.video.domain;

import com.example.dream.province.domain.Province;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="province_id")
    private Province province;
    private String title;
    private String url;
    private int likesCount;
    private int repliesCount;
    private String description;

    @Builder
    public Video(Province province, String title, String url, String description) {
        this.id = null;
        this.province = province;
        this.title = title;
        this.url = url;
        this.likesCount=0;
        this.repliesCount=0;
        this.description = description;
    }

}
