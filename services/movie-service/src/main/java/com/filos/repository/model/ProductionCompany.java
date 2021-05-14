package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.ToString;

@ToString
@QueryEntity
public class ProductionCompany {
    public long id;
    public String name;
}
