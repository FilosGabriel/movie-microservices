package com.filos.web.rest;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filos.services.MovieService;
import com.filos.services.SearchService;
import com.filos.web.requests.SaveMovieRequest;
import com.filos.web.requests.SearchRequest;
import com.filos.web.responses.MovieDto;
import com.filos.web.responses.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@Tag(name = "Movies endpoint", description = "Endpoints for retrieval and modifications of movies")
@RequiredArgsConstructor
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
public class MovieController {
    private final MovieService movieService;

    private final SearchService searchService;

    @GetMapping("/{id}")
    @Operation(summary = "Find movie by email")
    public MovieDto getMovieById(@PathVariable final String id) {
        return movieService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto createMovie(@Valid @RequestBody SaveMovieRequest movie) {
        return movieService.create(movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@PathVariable final String id) {
        movieService.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDto> getMovies() {
        return List.of();
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public PagedResponse<Object> search(@PageableDefault Pageable pageable, @Valid SearchRequest request) {
        return searchService.searchMovies(request, pageable);

    }
}
