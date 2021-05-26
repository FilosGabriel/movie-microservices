package com.filos.web.requests;

import javax.validation.constraints.NotBlank;

import com.filos.utils.validation.annotation.NotDuplicateMovie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NotDuplicateMovie
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
