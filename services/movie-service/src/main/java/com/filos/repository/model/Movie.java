package com.filos.repository.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Document
@AllArgsConstructor
@Getter
@Builder
@QueryEntity
public class Movie {
    @Id
    public long id;
    private final BasicInfo basic;
    private final SupplementaryInfo supplementary;
    private final StatisticInfo statistic;
    public List<Genre> genres;
    public List<Keyword> keywords;
    public List<ProductionCountry> countries;
    public List<ProductionCompany> companies;

}
