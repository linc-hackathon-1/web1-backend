package com.example.dream.province.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
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
    private int subscriberCounts;

    @Builder

    public Province(Long id, String name, String image, String intro, int subscriberCounts) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.intro = intro;
        this.subscriberCounts = subscriberCounts;
    }
}
