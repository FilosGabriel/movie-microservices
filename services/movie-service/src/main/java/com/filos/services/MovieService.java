package com.filos.services;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.filos.repository.model.Movie;
import com.filos.repository.mongo.MovieRepository;
import com.filos.utils.mapper.MovieMapper;
import com.filos.web.exceptions.MovieNotFound;
import com.filos.web.requests.SaveMovieRequest;
import com.filos.web.responses.MovieDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    public MovieDto findById(String id) {
        Movie movie = movieRepository.findById(id)
                                     .orElseThrow(MovieNotFound::new);
        return mapper.mapFromData(movie);
    }

    public MovieDto create(SaveMovieRequest movie) {
        Movie mappedMovie = mapper.mapFromData(movie);
        Movie savedMovie = movieRepository.save(mappedMovie);
        return mapper.mapFromData(savedMovie);
    }

    public void delete(String id) {
        Movie movie = movieRepository.findById(id)
                                     .orElseThrow(MovieNotFound::new);
        movieRepository.delete(movie);
    }
}
