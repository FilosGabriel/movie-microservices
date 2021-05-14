package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.ToString;

@ToString
@QueryEntity
public class Genre {
    public long id;
    public String  name;
}
