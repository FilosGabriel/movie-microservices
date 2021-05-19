package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@QueryEntity
public class Genre {
    public long id;
    public String  name;

}
