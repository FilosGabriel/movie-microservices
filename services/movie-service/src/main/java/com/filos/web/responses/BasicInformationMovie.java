package com.filos.web.responses;

import lombok.Data;

@Data
public class BasicInformationMovie{
    private String title;
    private String overview;
    private String tagline;
    private double runtime;
    public String homepage;
    public String originalLanguage;
    public float popularity;
}
