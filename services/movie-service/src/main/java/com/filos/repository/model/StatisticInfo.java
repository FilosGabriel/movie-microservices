package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

@Data
@QueryEntity
public class StatisticInfo {
    public long budget;
    public double revenue;
    public String releaseDate;

}
