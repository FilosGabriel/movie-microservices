package com.filos.utils.converters;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.filos.web.requests.search.FilterOption;
@Component
public class FilterOptionConverter implements Converter<String, Map<Long, FilterOption>> {
    @Override
    public Map<Long, FilterOption> convert(String source) {
        String[] strings = source.split(",");
        return Arrays.stream(strings)
                     .map(FilterOption::from)
                     .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
