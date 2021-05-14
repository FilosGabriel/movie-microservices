package com.filos.web.requests.search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Range<T> {
    private final T min;
    private final T max;

}
