package com.example.dream.schedular;

import com.example.dream.video.application.VideoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeekLikesSchedular {
    private final VideoService videoService;

    public WeekLikesSchedular(VideoService videoService) {
        this.videoService = videoService;
    }

    @Scheduled(cron = "0 0 3 ? * MON")
    public void clearWeekLikesCount() {
        videoService.clearWeekLikesCount();
    }
}
