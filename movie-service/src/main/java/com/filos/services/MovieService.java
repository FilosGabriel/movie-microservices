package com.filos.services;

import javax.naming.OperationNotSupportedException;

import org.springframework.stereotype.Service;

import com.filos.web.responses.MovieDto;
import lombok.SneakyThrows;

@Service
public class MovieService{
    @SneakyThrows
    public MovieDto findById(long id) {
        throw new OperationNotSupportedException();
    }

    @SneakyThrows
    public void create(MovieDto movie) {
        throw new OperationNotSupportedException();
    }

    public void delete(long id) {
    }
}
