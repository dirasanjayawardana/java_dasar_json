package dirapp.java_dasar_json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConfigurationTest {
  // dokumentasi configurasi feature --> https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features
  // cara menggunakannya dengan method --> configure(FeaturNya, true/false)

  // untuk saat ini, MapperFeature sudah deprecated, bisa gunakan SerializationFeature atau DeserializationFeature
  // Serialization (mengubah object menjadi format data yang bisa disimpan, seperti JSON, XML, dll)
  // Deserialization (mengubah format data seperti JSON menjadi Object)

  @Test
  void mapperFeature() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true); // membolehkan attribute tidak harus sama persis lowercase atau uppercase dengan field di TypeReference nya
        // contohnya id di class Person lowercase, tetapi JSON yang dibaca adalah uppercase

    String json = """
        {"ID" : "1", "Name": "Dira"}
        """;

    Person person = objectMapper.readValue(json, Person.class);
    Assertions.assertEquals("1", person.getId());
    Assertions.assertEquals("Dira", person.getName());
  }


  @Test
  void deserializationFeature() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper()
        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) // ketika ada attribute yang tidak ada di TypeReference nya, tidak akan muncul error, defaultnya true
        .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true); // akan menerima data dalam bentuk array meskipun hanya satu data, contohnya pada hobbies di class Person adalah array, meski data di JSON hanya single value, tetap akan di baca sebagai array

    String json = """
        {"id" : "1", "name": "Dira", "age": 30, "hobbies" : "Coding"}
        """;

    Person person = objectMapper.readValue(json, Person.class);
    Assertions.assertEquals("1", person.getId());
    Assertions.assertEquals("Dira", person.getName());
    Assertions.assertEquals(List.of("Coding"), person.getHobbies());
  }


  @Test
  void serializationFeature() throws JsonProcessingException {
    Person person = new Person();
    person.setId("1");
    person.setName("Dira");
    person.setHobbies(List.of("Coding", "Reading"));

    Address address = new Address();
    address.setStreet("Jalan belum jadi");
    address.setCity("Jakarta");
    address.setCountry("Indonesia");
    person.setAddress(address);

    ObjectMapper objectMapper = new ObjectMapper()
        .configure(SerializationFeature.INDENT_OUTPUT, true);  // agar format JSON yang dihasilkan lebih rapi
    String json = objectMapper.writeValueAsString(person);

    System.out.println(json);
  }


  // Serialization Incluesion untuk mengatur field mana saja yang akan dibuat sebagai attribute di JSON
  @Test
  void serializationInclusion() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL); // hanya membuat attribute JSON yang valueNya tidak null

    Person person = new Person();
    person.setId("1");
    person.setName("Dira");

    String json = objectMapper.writeValueAsString(person);
    System.out.println(json);
  }
}
