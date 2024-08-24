package dirapp.java_dasar_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ssl.SslProperties.Bundles.Watch.File;

import java.util.Map;

public class JsonObjectTest {
  // JSON Object adalah data berisikan atribute dan value, di Java mirip dengan Map
  // untuk membuat JSON, bisa dengan membuat Map, lalu gunakan ObjectMapper untuk konversi ke JSON

  // writeValue(output, object) --> dimana output adalah Writer, File atau OutputStream
  // writeValueAsString(object) --> dimana hasilnya adalah JSON dalam String
  // writerValueAsBytes(object) --> dimana hasilnya adalah JSON dalam byte[]

  // readValue(input, typeReference) --> dimana input adalah InputStream, Reader, String, File, dan typeReference adalah class untuk Generic


  @Test
  void createJson() throws JsonProcessingException {
    Map<String, Object> person = Map.of(
        "firstName", "Dira",
        "lastName", "Sanjaya",
        "age", 30,
        "married", true,
        "address", Map.of(
            "street", "Jalan belum ada",
            "city", "Jakarta",
            "country", "Indonesia"));

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // agar format JSON mudah dibaca

    String json = objectMapper.writeValueAsString(person);
    // objectMapper.writeValue(new File("contoh.json"), person); // menyimpan JSON ke dalam file contoh.json

    System.out.println(json);
  }


  @Test
  void readJson() throws JsonProcessingException {
    String json = """
        {
          "age": 30,
          "address": {
            "street": "Jalan belum ada",
            "city": "Jakarta",
            "country": "Indonesia"
          },
          "firstName": "Dira",
          "lastName": "Sanjaya",
          "married": true
        }
        """;

    ObjectMapper objectMapper = new ObjectMapper();
    Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
    });

    Assertions.assertEquals("Dira", person.get("firstName"));
    Assertions.assertEquals("Sanjaya", person.get("lastName"));
  }
}