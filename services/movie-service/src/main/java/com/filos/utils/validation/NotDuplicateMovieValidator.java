package com.filos.utils.validation;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.filos.repository.model.Movie;
import com.filos.repository.model.QMovie;
import com.filos.repository.mongo.MovieRepository;
import com.filos.utils.validation.annotation.NotDuplicateMovie;
import com.filos.web.requests.SaveMovieRequest;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotDuplicateMovieValidator implements ConstraintValidator<NotDuplicateMovie, SaveMovieRequest> {
    private final MovieRepository repository;

    @Override
    public boolean isValid(SaveMovieRequest value, ConstraintValidatorContext context) {
        Optional<Movie> movie = repository.findOne(createPredicate(value));
        return movie.isEmpty();
    }

    private Predicate createPredicate(SaveMovieRequest saveMovieRequest) {
        BooleanExpression idEquals = QMovie.movie.imdbId.eq(saveMovieRequest.getIdmdbId());
        return QMovie.movie.basic.title.equalsIgnoreCase(saveMovieRequest.getTitle())
                                       .or(idEquals);
    }
}
