package com.filos.data;

import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filos.config.DataLoader;
import com.filos.utils.collectors.DataCollector;
import lombok.SneakyThrows;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

@Component
@ConditionalOnBean(DataLoader.class)
public class DataReader {
    @Value("statistics.load.file")
    private String fileName;
    private final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public Map<String, Long> readDataFromFile() {
        Reader fileReader = new FileReader(fileName);
        return CsvReader.builder()
                        .build(fileReader)
                        .stream()
                        .skip(1)
                        .map(this::processRow)
                        .collect(DataCollector.toMap());
    }

    private Map<String, Long> processRow(CsvRow row) {
        Map<String, Long> values = new HashMap<>();
        values.putAll(count(row, "genre", 1));
        values.putAll(count(row, "keyword", 4));
        values.putAll(count(row, "companies", 9));
        return values;
    }

    private Map<String, Long> count(CsvRow row, String name, int index) {
        return Arrays.stream(loadAsMap(row.getField(index)))
                     .collect(Collectors.toMap(value -> name + ":" + value.get("id"), value -> 1L));

    }

    @SneakyThrows
    private Map<String, Long>[] loadAsMap(String content) {
        return mapper.readValue(content, Map[].class);
    }
}
