package com.filos.web.requests;

import lombok.Data;

@Data
public class SaveMovieRequest {
    public String title;
    public String overview;
    public String originalTitle;
    public String tagline;
    public double runtime;
    public String homepage;
    public String originalLanguage;
    public float popularity;
    public long budget;
    public double revenue;
    public String releaseDate;
}
