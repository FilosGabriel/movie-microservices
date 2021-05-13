package com.filos.converters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.filos.data.ProductionCompany;
import com.google.gson.Gson;
import com.univocity.parsers.conversions.Conversion;

public class JsonConverterCompanies implements Conversion<String, List<ProductionCompany>> {

    @Override
    public List<ProductionCompany> execute(String input) {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(new Gson().fromJson(input, ProductionCompany[].class)).collect(Collectors.toList());
    }

    @Override
    public String revert(List<ProductionCompany> input) {
        return null;
    }
}
