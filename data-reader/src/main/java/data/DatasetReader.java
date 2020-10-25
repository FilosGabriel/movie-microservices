package data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;
import dto.Genre;
import org.apache.tomcat.util.json.JSONParser;
import tech.tablesaw.api.Table;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DatasetReader {

    public static void readData(File file) throws IOException {
        System.out.println(Table.read().csv(file).row(1).getString("genres"));
        JSONParser parser = new JSONParser("");
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        new TypeReference<List<Genre>>() {
        };

        System.out.println(mapper.readValue("{\"id\": 12, \"name\": \"Adventure\"}", new TypeReference<Genre>() {
        }).toString());
//        readData(new File("C:/Users/filos/Downloads/archive (1)/tmdb_5000_movies.csv/"));
    }
}

