package dirapp.java_dasar_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonArrayTest {
  // Untuk representasi JSON array di Java, bisa menggunakan tipe data collection sperti List atau Set

  // writeValue(output, object) --> dimana output adalah Writer, File atau OutputStream
  // writeValueAsString(object) --> dimana hasilnya adalah JSON dalam String
  // writerValueAsBytes(object) --> dimana hasilnya adalah JSON dalam byte[]

  // readValue(input, typeReference) --> dimana input adalah InputStream, Reader, String, File, dan typeReference adalah class untuk Generic


  @Test
  void createJsonArray() throws JsonProcessingException {
    List<String> hobbies = List.of("Coding", "Reading", "Traveling");

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(hobbies);

    System.out.println(json);
  }


  @Test
  void readJsonArray() throws JsonProcessingException {
    String json = """
        ["Coding","Reading","Traveling"]
        """;

    ObjectMapper objectMapper = new ObjectMapper();
    List<String> hobbies = objectMapper.readValue(json, new TypeReference<List<String>>() {
    });

    Assertions.assertEquals(List.of("Coding", "Reading", "Traveling"), hobbies);
  }
}