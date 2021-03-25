package com.filos.services;

import com.filos.dtos.MovieDto;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;

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
