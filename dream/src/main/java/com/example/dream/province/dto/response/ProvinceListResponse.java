package com.example.dream.province.dto.response;

import com.example.dream.province.dto.ProvincePreviewDto;

import java.util.List;

public record ProvinceListResponse(
        List<ProvincePreviewDto> provinces
) {
    public static ProvinceListResponse of(List<ProvincePreviewDto> provincePreviewDtos){
        return new ProvinceListResponse(provincePreviewDtos);
    }
}
