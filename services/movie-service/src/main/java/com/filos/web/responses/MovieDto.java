package com.filos.web.responses;

import lombok.Data;

@Data
//imdb_title_id,title,original_title,year,date_published,genre,duration,country,language,director,writer,production_company,actors,
// description,avg_vote,votes,budget,usa_gross_income,worlwide_gross_income,metascore,reviews_from_users,reviews_from_critics
public class MovieDto {
    private long id;
    private final BasicInformationMovie basic;
    private final DetailedInformation details;
    private final Statistics statistics;
}
