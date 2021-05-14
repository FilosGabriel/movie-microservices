package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.ToString;

@ToString
@QueryEntity
public class Keyword {
    public long id;
    public String name;
}
