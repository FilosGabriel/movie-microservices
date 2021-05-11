package com.filos.web.rest;

import com.filos.services.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class GenreController{
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
    public List<String> updateGenresForMovie(@PathVariable final long id,
                                             @Valid @RequestBody List<String> genres) {
        return genresService.updateGenresForMovie(id,genres);
    }

}
