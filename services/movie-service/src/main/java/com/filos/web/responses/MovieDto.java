package com.filos.web.responses;

import lombok.Data;

@Data
public class MovieDto {
    private String id;
    private long imdbId;
    private final BasicInformationMovie basic;
    private final DetailedInformation details;
    private final Statistics statistics;
}
