package com.filos.converters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.filos.data.ProductionCountry;
import com.google.gson.Gson;
import com.univocity.parsers.conversions.Conversion;

public class JsonConverterCountry implements Conversion<String, List<ProductionCountry>> {
    @Override
    public List<ProductionCountry> execute(String input) {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(new Gson().fromJson(input, ProductionCountry[].class)).collect(Collectors.toList());
    }

    @Override
    public String revert(List<ProductionCountry> input) {
        return null;
    }
}
