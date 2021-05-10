package com.filos.repository.model;

import com.univocity.parsers.annotations.Parsed;
import lombok.ToString;

@ToString
public class ProductionCompany {
    @Parsed
    public long id;
    @Parsed
    public String name;
}
