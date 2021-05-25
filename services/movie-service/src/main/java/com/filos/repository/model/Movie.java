package com.filos.repository.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@QueryEntity
public class Movie {
    @Id
    private String id;
    @Indexed
    private long imdbId;
    private BasicInfo basic;
    private SupplementaryInfo supplementary;
    private StatisticInfo statistic;
    private List<Genre> genres;
    private List<Keyword> keywords;
    private List<ProductionCountry> countries;
    private List<ProductionCompany> companies;

}
