package com.filos.repository.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;

@Data
@QueryEntity
public class BasicInfo {
    private String tagline;
    private String title;
    private String overview;
    private String originalTitle;
    private double runtime;
}
