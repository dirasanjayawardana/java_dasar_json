package dirapp.java_dasar_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {
  // class java been (class yang ada getter setter nya)
  // jackson bisa melakukan konversi Object menjadi JSON, dimana attribute JSON nya akan menggunakan nama field class nya

  // writeValue(output, object) --> dimana output adalah Writer, File atau OutputStream
  // writeValueAsString(object) --> dimana hasilnya adalah JSON dalam String
  // writerValueAsBytes(object) --> dimana hasilnya adalah JSON dalam byte[]

  // readValue(input, typeReference) --> dimana input adalah InputStream, Reader, String, File, dan typeReference adalah class untuk Generic (new TypeReference<T> atau langsung ContohClass.class nya)


  @Test
  void createJsonFromObject() throws JsonProcessingException {
    Person person = new Person();
    person.setId("1");
    person.setName("Dira");
    person.setHobbies(List.of("Coding", "Reading"));

    Address address = new Address();
    address.setStreet("Jalan belum jadi");
    address.setCity("Jakarta");
    address.setCountry("Indonesia");
    person.setAddress(address);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // agar format JSON mudah dibaca
    
    String json = objectMapper.writeValueAsString(person);
    // objectMapper.writeValue(new File("contoh.json"), person); // menyimpan JSON ke dalam file contoh.json

    System.out.println(json);
  }


  @Test
  void readObjectFromJson() throws JsonProcessingException {
    String json = """
        {
          "id": "1",
          "name": "Dira",
          "hobbies": [
            "Coding",
            "Reading"
          ],
          "address": {
            "street": "Jalan belum jadi",
            "city": "Jakarta",
            "country": "Indonesia"
          }
        }
        """;

    ObjectMapper objectMapper = new ObjectMapper();
    Person person = objectMapper.readValue(json, Person.class);
    // objectMapper.readValue(new File("contohData.json"), new TypeReference<List<Person>>() {});

    Assertions.assertEquals("1", person.getId());
    Assertions.assertEquals("Dira", person.getName());
    Assertions.assertEquals("Jalan belum jadi", person.getAddress().getStreet());
    Assertions.assertEquals("Jakarta", person.getAddress().getCity());
    Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
  }
}
