package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

@Data
@QueryEntity
public class StatisticInfo {
    private long budget;
    private double revenue;
    private String releaseDate;

}
