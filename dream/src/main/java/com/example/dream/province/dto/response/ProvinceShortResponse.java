package com.example.dream.province.dto.response;

import com.example.dream.province.domain.Province;

public record ProvinceShortResponse(
        String name,
        String image
) {
    public static ProvinceShortResponse of(Province province){
        return new ProvinceShortResponse(
                province.getName(),
                province.getProfileImage()
        );
    }
}
