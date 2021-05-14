package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

@Data
@QueryEntity
public class BasicInfo {
    public String title;
    public String overview;
    public String originalTitle;
    public String tagline;
    public double runtime;
}
