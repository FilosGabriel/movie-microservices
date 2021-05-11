package com.filos.web.responses;

import lombok.Data;

import java.util.List;

@Data
public class DetailedInformation{
    private List<String> countries;
    private List<String> genres;
    private List<String> actors;
}
