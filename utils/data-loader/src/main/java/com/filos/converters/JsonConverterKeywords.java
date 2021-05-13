package com.filos.converters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.filos.data.Keyword;
import com.google.gson.Gson;
import com.univocity.parsers.conversions.Conversion;

public class JsonConverterKeywords implements Conversion<String, List<Keyword>> {
    @Override
    public List<Keyword> execute(String input) {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(new Gson().fromJson(input, Keyword[].class)).collect(Collectors.toList());
    }

    @Override
    public String revert(List<Keyword> input) {
        return null;
    }
}
