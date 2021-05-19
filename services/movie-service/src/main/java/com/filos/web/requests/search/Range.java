package com.filos.web.requests.search;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Range<T> {
    private final T min;
    private final T max;

}
