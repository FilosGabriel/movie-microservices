package com.filos.web.requests;

import java.util.Map;

import com.filos.utils.validation.annotation.ValidRangeRuntime;
import com.filos.web.requests.search.Defaults;
import com.filos.web.requests.search.FilterOption;
import com.filos.web.requests.search.Range;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest implements OriginalRequest {
    @Schema(name = "Name of title", description = "The text witch will be searched.", example ="Avatar")
    private String text = "";
    private Map<Long, FilterOption> genres = Defaults.RESTRICTED_MAP;
    private Map<Long, FilterOption> keywords = Defaults.RESTRICTED_MAP;
    private Map<Long, FilterOption> countries = Defaults.RESTRICTED_MAP;
    private Map<Long, FilterOption> companies = Defaults.RESTRICTED_MAP;
    @ValidRangeRuntime
    private Range<Double> runtime = Defaults.RUNTIME;
    private Range<String> release = Defaults.RELEASE;

}
