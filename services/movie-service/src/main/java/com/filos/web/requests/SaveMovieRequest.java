package com.filos.web.requests;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveMovieRequest {
    @NotBlank
    private String title;
    private long idmdbId;
    private String overview;
    private String originalTitle;
    private String tagline;
    private double runtime;
    private String homepage;
    private String originalLanguage;
    private float popularity;
    private long budget;
    private double revenue;
    private String releaseDate;
}
