package com.filos.services;

import org.springframework.stereotype.Service;

import com.filos.repository.model.Movie;
import com.filos.repository.mongo.MovieRepository;
import com.filos.utils.mapper.MovieMapper;
import com.filos.web.exceptions.MovieNotFound;
import com.filos.web.requests.SaveMovieRequest;
import com.filos.web.responses.MovieDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    @SneakyThrows
    public MovieDto findById(long id) {
        Movie movie = movieRepository.findById(id)
                                     .orElseThrow(MovieNotFound::new);
        return mapper.mapFromData(movie);
    }

    @SneakyThrows
    public void create(SaveMovieRequest movie) {
        Movie mappedMovie = mapper.mapFromData(movie);
        movieRepository.save(mappedMovie);
    }

    public void delete(long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFound::new);
        movieRepository.delete(movie);
    }
}
