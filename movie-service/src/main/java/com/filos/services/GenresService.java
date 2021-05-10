package com.filos.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class GenresService {
    public Map<String, Long> getAllGenres() {
        return Map.of();
    }

    public List<String> getGenresForMovieId(long id) {
        return List.of();
    }

    public List<String> updateGenresForMovie(long id) {
        return List.of();
    }
}
