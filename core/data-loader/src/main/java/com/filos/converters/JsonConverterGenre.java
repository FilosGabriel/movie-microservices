package com.filos.converters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.filos.data.Genre;
import com.google.gson.Gson;
import com.univocity.parsers.conversions.Conversion;

public class JsonConverterGenre implements Conversion<String, List<Genre>> {
    @Override
    public List<Genre> execute(String input) {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(new Gson().fromJson(input, Genre[].class)).collect(Collectors.toList());
    }

    @Override
    public String revert(List<Genre> input) {
        return null;
    }
}
