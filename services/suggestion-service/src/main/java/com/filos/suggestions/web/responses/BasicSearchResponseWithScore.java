package com.filos.suggestions.web.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BasicSearchResponseWithScore extends BasicSearchResponse {
    private float score;
}
