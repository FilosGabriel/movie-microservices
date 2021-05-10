package com.filos.web.responses;

import lombok.Data;

@Data
public class Statistics{
    private double averageVote;
    private long votes;
    private double budget;
    private double income;
    private double metaScore;
}
