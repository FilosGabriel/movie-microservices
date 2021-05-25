package com.filos.repository.load;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.filos.reader.MovieReader;
import com.filos.repository.model.Movie;
import com.filos.utils.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader {
    private final MovieReader reader;
    private final MovieMapper mapper;
    private final MongoTemplate template;

    @PostConstruct
    public void initDbWithData() {
        List<Movie> collect = reader.readCsv()
                                    .stream()
                                    .map(mapper::mapFromData)
                                    .collect(Collectors.toList());
        log.info("Drop collection Movie");
        template.dropCollection(Movie.class);
        log.info("Inserting data in the database.");
        int insertedCount = template.bulkOps(BulkOperations.BulkMode.UNORDERED, Movie.class)
                                    .insert(collect)
                                    .execute()
                                    .getInsertedCount();
        log.info("In the database was inserted {}", insertedCount);
    }
}
