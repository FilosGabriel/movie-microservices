package com.filos.controller;

import com.filos.dtos.MovieDto;
import com.filos.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
