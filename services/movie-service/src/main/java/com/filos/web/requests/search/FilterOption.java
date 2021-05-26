package com.filos.web.requests.search;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum FilterOption {
    ALLOW,
    BLOCK;

    public static Map.Entry<Long, FilterOption> from(String value) {
        if (value.startsWith("-")) {
            return Map.entry(Long.parseLong(value.substring(1)), FilterOption.BLOCK);
        }
        if (value.startsWith("+")) {
            return Map.entry(Long.parseLong(value.substring(1)), FilterOption.ALLOW);
        }
        return Map.entry(Long.parseLong(value), FilterOption.ALLOW);
    }

    public static <T> List<T> extractAllowed(Map<T, FilterOption> values) {
        return extractAllowed(values, ALLOW);
    }

    public static <T> List<T> extractDenied(Map<T, FilterOption> values) {
        return extractAllowed(values, BLOCK);
    }

    private static <T> List<T> extractAllowed(Map<T, FilterOption> values, FilterOption option) {
        return values.entrySet()
                     .stream()
                     .filter(value -> value.getValue()
                                           .equals(option))
                     .map(Map.Entry::getKey)
                     .collect(Collectors.toList());
    }

}
