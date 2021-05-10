package com.filos.reader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.filos.data.Movie;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import lombok.Cleanup;
import lombok.SneakyThrows;

public final class MovieReader {
    private final String filePath;
    private List<Movie> moviesCache;

    public MovieReader(String filePath) {
        this.filePath = filePath;
    }

    public void clearCache() {
        moviesCache = null;
    }

    @SneakyThrows
    public List<Movie> readCsv() {
        if (moviesCache != null) {
            return moviesCache;
        }
        FileInputStream fileInputStream = new FileInputStream(filePath);
        @Cleanup Reader inputReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BeanListProcessor<Movie> rowProcessor = new BeanListProcessor<>(Movie.class);
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        settings.setQuoteDetectionEnabled(true);
        settings.setColumnReorderingEnabled(false);
        settings.setSkipEmptyLines(true);
        settings.getFormat().setLineSeparator("\n");
//        settings.setHeaders("budget","genres","homepage","id","keywords","original_language","original_title","overview","popularity","production_companies","production_countries","release_date","revenue","runtime","spoken_languages","status","tagline","title","vote_average","vote_count");
        settings.setProcessor(rowProcessor);
        CsvParser parser = new CsvParser(settings);
        parser.parse(inputReader);
        moviesCache = rowProcessor.getBeans();
        return moviesCache;
    }

    public static void main(String[] args) {
        MovieReader movieReader = new MovieReader("C:\\Users\\gfilos\\Downloads\\movie-microservices\\data\\tmdb_5000_movies.csv");
        System.out.println(movieReader.readCsv());
    }

}
