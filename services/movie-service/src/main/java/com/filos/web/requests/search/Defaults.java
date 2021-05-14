package com.filos.web.requests.search;

import java.util.Map;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Defaults {
    public static final Map<Long, FilterOption> RESTRICTED_MAP = Map.of();
    public static final Range<Double> RUNTIME = new Range<>(0.0, 99999.0);
    public static final Range<String> RELEASE = new Range<>("0.0", "99999.0");
}
