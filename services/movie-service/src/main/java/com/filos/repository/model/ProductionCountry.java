package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.ToString;

@ToString
@QueryEntity
public class ProductionCountry {
    public String iso;
    public String name;
}
