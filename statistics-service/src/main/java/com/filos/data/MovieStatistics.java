package com.filos.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MovieStatistics{
    @Id
    private final Integer id;
}
