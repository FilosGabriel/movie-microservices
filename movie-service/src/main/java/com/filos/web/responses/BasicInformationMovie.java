package com.filos.web.responses;

import lombok.Data;

import java.time.LocalDate;
import java.time.Year;

@Data
public class BasicInformationMovie{
    private String title;
    private long duration;
    private Year year;
    private String description;
    private LocalDate dateOfPublishing;

}
