package com.example.dream.reply.domain;

import com.example.dream.user.domain.User;
import com.example.dream.video.domain.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="replies")
@EntityListeners(AuditingEntityListener.class)
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="video_id")
    private Video video;
    @Column(length = 256)
    private String content;
    @LastModifiedDate
    private LocalDateTime upadtedAt;
}
