package com.example.dream.province.repository;

import com.example.dream.province.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    List<Province> findAllByOrderByTotalLikesCountsDesc();
    List<Province> findAllByOrderByWeekLikesCountsDesc();
}
