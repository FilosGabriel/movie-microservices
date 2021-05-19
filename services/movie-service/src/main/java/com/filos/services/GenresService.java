package com.filos.services;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.filos.repository.model.Genre;
import com.filos.repository.model.GenreNo;
import com.filos.repository.model.Movie;
import com.filos.services.builder.QueryBuilder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenresService {

    private final MongoTemplate template;
    private final QueryBuilder queryBuilder;

    public Map<String, Long> getAllGenres() {
        return template.findAll(GenreNo.class).stream()
                       .collect(Collectors.toMap(GenreNo::getName, GenreNo::getNo));
    }

    public List<String> getGenresForMovieId(long id) {
        Query query = queryBuilder.createGenreQueryForSpecificMovie(id);
        Movie genres = template.findOne(query, Movie.class);
        return mapToResponse(genres);
    }

    public void updateGenresForMovie(long id, Map<String, Long> newGenres) {
        Query query = queryBuilder.createGenreQueryForSpecificMovie(id);
        Movie movie = template.findOne(query, Movie.class);
        movie.getGenres().stream().map(Genre::getName)
             .collect(Collectors.toList()).forEach(newGenres::remove);
        Update update = new Update();
        newGenres.forEach((name, i) -> update.push("genres", new Genre(i, name)));
        template.findAndModify(query, update, Movie.class);
    }

    public void deleteGenresForMovie(long id, Set<Long> genresToRemove) {
        Query query = queryBuilder.createGenreQueryForSpecificMovie(id);
        Movie movie = template.findOne(query, Movie.class);
        List<Genre> genresToBeRemoved = movie.getGenres().stream().filter(genre -> genresToRemove.contains(genre))
                                             .collect(Collectors.toList());
        movie.getGenres().removeAll(genresToBeRemoved);
        template.save(movie);
    }

    private List<String> mapToResponse(Movie movie) {
        return movie.getGenres()
                    .stream()
                    .map(Genre::getName)
                    .collect(Collectors.toList());
    }
}
