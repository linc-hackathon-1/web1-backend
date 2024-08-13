package com.example.dream.province.dto;

import com.example.dream.province.domain.Province;

public record ProvincePreviewDto(
        String name,
        String image,
        int likesCount
) {
    public static ProvincePreviewDto fromWeekLikesProvince(Province province){
        return new ProvincePreviewDto(
                province.getName(),
                province.getImage(),
                province.getWeekLikesCounts()
        );
    }

    public static ProvincePreviewDto fromTotalLikesProvince(Province province){
        return new ProvincePreviewDto(
                province.getName(),
                province.getImage(),
                province.getTotalLikesCounts()
        );
    }
}
