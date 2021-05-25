package com.filos.web.responses;

import java.util.List;

import lombok.Data;

@Data
public class DetailedInformation {
    private List<String> countries = List.of();
    private List<String> companies = List.of();
    private List<String> genres = List.of();
    private List<String> keywords = List.of();
}
