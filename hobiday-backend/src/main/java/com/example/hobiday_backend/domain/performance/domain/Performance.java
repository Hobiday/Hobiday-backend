package com.example.hobiday_backend.domain.performance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Performance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name="prfnm", nullable=false)
    private String prfnm; // 공연명

    @Column(name="prfpdfrom", nullable=false)
    private String prfpdfrom; // 시작일

    @Column(name="prfpdto", nullable=false)
    private String prfpdto; // 종료일

    @Column(name="genrenm", nullable=false)
    private String genrenm; // 장르명

    @Column(name="fcltynm", nullable=false)
    private String fcltynm; // 공연시설명

    @Column(name="area", nullable=false)
    private String area; // 지역명

    @Column(name = "poster", nullable=false)
    private String poster; // 공연포스터 경로

    @Builder
    public Performance(String prfnm, String prfpdfrom, String prfpdto, String genrenm, String fcltynm, String area, String poster) {
        this.prfnm = prfnm;
        this.prfpdfrom = prfpdfrom;
        this.prfpdto = prfpdto;
        this.genrenm = genrenm;
        this.fcltynm = fcltynm;
        this.area = area;
        this.poster = poster;
    }
}
