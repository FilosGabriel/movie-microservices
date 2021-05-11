package com.filos.repository.load;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.filos.data.Movie;
import com.filos.reader.MovieReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader {
    private final MovieReader reader;

    @PostConstruct
    public void initDbWithData(){
        List<Movie> movies = reader.readCsv();

    }
}
