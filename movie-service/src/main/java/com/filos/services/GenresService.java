package com.filos.services;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Service
public class GenresService{
    public Map<String, Long> getAllGenres() {
        return Map.of();
    }

    public List<String> getGenresForMovieId(long id) {
    }

    public List<String> updateGenresForMovie(long id) {
    }
}
