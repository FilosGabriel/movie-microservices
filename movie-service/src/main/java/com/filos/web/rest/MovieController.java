package com.filos.web.rest;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filos.web.responses.MovieDto;
import com.filos.services.MovieService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController{
    private final MovieService movieService;

    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable final long id) {
        return movieService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@Valid MovieDto movie) {
        movieService.create(movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@PathVariable final long id) {
        movieService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDto> getMovies() {
        return List.of();
    }

}