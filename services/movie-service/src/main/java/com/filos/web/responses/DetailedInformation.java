package com.filos.web.responses;

import java.util.List;

import lombok.Data;

@Data
public class DetailedInformation{
    private List<String> countries;
    private List<String> companies;
    private List<String> genres;
    private List<String> keywords;
}
