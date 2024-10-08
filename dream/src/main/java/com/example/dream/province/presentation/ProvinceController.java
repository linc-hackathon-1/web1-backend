package com.example.dream.province.presentation;

import com.example.dream.province.application.ProvinceService;
import com.example.dream.province.dto.response.ProvinceDetailResponse;
import com.example.dream.province.dto.response.ProvinceListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/province")
@Tag(name = "지역 관련 컨트롤러")
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping ("/ranking-list")
    @Operation(description = "지역 정보를 좋아요 내림차순으로 불러온다.")
    public ResponseEntity<ProvinceListResponse> getProvinceRanking(@RequestParam String sort) {
        ProvinceListResponse response = provinceService.getProvinceRanking(sort);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping ("/{provinceId}")
    @Operation(description = "지역 상세 정보를 불러온다.")
    public ResponseEntity<ProvinceDetailResponse> getProvinceDetail(@PathVariable("provinceId") Long provinceId) {
        ProvinceDetailResponse response = provinceService.getProvinceDetail(provinceId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
