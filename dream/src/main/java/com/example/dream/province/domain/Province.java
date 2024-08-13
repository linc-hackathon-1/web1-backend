package com.example.dream.province.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 16)
    private String name;
    @Column(length = 512)
    private String image;
    @Column(length = 2048)
    private String intro;
    private int totalLikesCounts;

    public void addLikesCount() {
        this.totalLikesCounts++;
    }

    public void subLikesCount() {
        this.totalLikesCounts--;
    }
}
