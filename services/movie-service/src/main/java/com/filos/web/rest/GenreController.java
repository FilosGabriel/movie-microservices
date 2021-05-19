package com.filos.web.rest;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filos.services.GenresService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class GenreController {
    private final GenresService genresService;

    @GetMapping("/genres")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Long> getAllGenres() {
        return genresService.getAllGenres();
    }

    @GetMapping("/{id}/genres")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getGenresForMovie(@PathVariable final long id) {
        return genresService.getGenresForMovieId(id);
    }

    @PutMapping("/{id}/genres")
    @ResponseStatus(HttpStatus.OK)
    public void updateGenresForMovie(@PathVariable final long id,
                                             @Valid @RequestBody List<String> genres) {
         genresService.updateGenresForMovie(id, Map.of());
    }

}
