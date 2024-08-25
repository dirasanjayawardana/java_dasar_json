package dirapp.java_dasar_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {
  // JSON tidak memiliki tipe data Date Time
  // untuk menampilkan Date Time di JSON, bisa dengan number dalam format millis, atau String misalnya yyyy-MM-dd
  // secara defaut Jackson akan menampilkan Date Time dalam format number (millis)


  @Test
  void dateTime() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    Person person = new Person();
    person.setId("1");
    person.setName("Dira");
    person.setCreatedAt(new Date());
    person.setUpdatedAt(new Date());

    String json = objectMapper.writeValueAsString(person);
    System.out.println(json);
  }


  @Test
  void dateFormat() throws JsonProcessingException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    ObjectMapper objectMapper = new ObjectMapper()
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false) // mematikan fitur millis untuk date
        .setDateFormat(dateFormat); // format date akan mengikuti format dateFormat

    Person person = new Person();
    person.setId("1");
    person.setName("Dira");
    person.setCreatedAt(new Date());
    person.setUpdatedAt(new Date());

    String json = objectMapper.writeValueAsString(person);
    System.out.println(json);
  }
}