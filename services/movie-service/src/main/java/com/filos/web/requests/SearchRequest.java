package com.filos.web.requests;

import java.util.Map;

import org.springframework.data.domain.PageRequest;

import com.filos.web.requests.search.Defaults;
import com.filos.web.requests.search.FilterOption;
import com.filos.web.requests.search.Range;
import lombok.Data;

@Data
public class SearchRequest {
    private String text;
    private PageRequest pageRequest;
    private Map<Long, FilterOption> genres = Defaults.RESTRICTED_MAP;
    private Map<Long, FilterOption> keywords = Defaults.RESTRICTED_MAP;
    private Map<Long, FilterOption> countries = Defaults.RESTRICTED_MAP;
    private Map<Long, FilterOption> companies = Defaults.RESTRICTED_MAP;
    private Range<Double> runtime = Defaults.RUNTIME;
    private Range<String> release = Defaults.RELEASE;
}
