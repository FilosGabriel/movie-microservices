package com.filos.services.builder;

import com.filos.web.requests.SearchRequest;

public interface IntermediaryBuilder {
    FinalBuilder create(SearchRequest request);
}
