package com.example.dream.province.application;

import com.example.dream.province.domain.Province;
import com.example.dream.province.dto.ProvincePreviewDto;
import com.example.dream.province.dto.response.ProvinceDetailResponse;
import com.example.dream.province.dto.response.ProvinceListResponse;
import com.example.dream.province.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public ProvinceListResponse getProvinceRanking(String sort) {
        List<Province> provinces;
        List<ProvincePreviewDto> provincePreviewDtos=new ArrayList<>();
        if(sort.equals("week")){
            provinces = provinceRepository.findAllByOrderByWeekLikesCountsDesc();
            provincePreviewDtos = provinces.stream()
                    .map(ProvincePreviewDto::fromWeekLikesProvince)
                    .collect(Collectors.toList());
        }
        else if(sort.equals("total")){
            provinces = provinceRepository.findAllByOrderByTotalLikesCountsDesc();
            provincePreviewDtos = provinces.stream()
                    .map(ProvincePreviewDto::fromTotalLikesProvince)
                    .collect(Collectors.toList());
        }

        return ProvinceListResponse.of(provincePreviewDtos);
    }

    public ProvinceDetailResponse getProvinceDetail(Long provinceId) {
        Province province = provinceRepository.findById(provinceId)
                .orElseThrow(() -> new IllegalArgumentException("no province"));
        return ProvinceDetailResponse.of(province);
    }
}
