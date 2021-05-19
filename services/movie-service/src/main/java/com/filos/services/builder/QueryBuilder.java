package com.filos.services.builder;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {

    public Query createGenreQueryForSpecificMovie(final long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id))
             .fields().include("genres")
             .exclude("basic", "supplementary", "statistic", "keywords", "countries", "companies");
        return query;
    }

}
