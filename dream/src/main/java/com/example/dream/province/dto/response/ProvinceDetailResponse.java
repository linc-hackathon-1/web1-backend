package com.example.dream.province.dto.response;

import com.example.dream.province.domain.Province;

public record ProvinceDetailResponse(
        String name,
        String thumbnail,
        String profileImage,
        String intro,
        int totalLikesCounts

) {
    public static ProvinceDetailResponse of(Province province){
        return new ProvinceDetailResponse(
                province.getName(),
                province.getThumbnail(),
                province.getProfileImage(),
                province.getIntro(),
                province.getTotalLikesCounts()
        );
    }
}
