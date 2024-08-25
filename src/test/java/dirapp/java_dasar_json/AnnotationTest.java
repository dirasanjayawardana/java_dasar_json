package dirapp.java_dasar_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnotationTest {
  // Jackson secara default akan membuat JSON dari Java Class, dari membaca field yang ada
  // Jackson menyediakan beberapa annotasi untuk mengubah behaviour default dari Jackson dengan menamabahkan Annotation pada class Java nya

  @Test
  void annotation() throws JsonProcessingException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    ObjectMapper objectMapper = new ObjectMapper()
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .configure(SerializationFeature.INDENT_OUTPUT, true)
        .setDateFormat(dateFormat);

    Person person = new Person();
    person.setId("1");
    person.setName("Dira");
    person.setFullName("Dira Sanjaya wardana");
    person.setPassword("test");
    person.setCreatedAt(new Date());
    person.setUpdatedAt(new Date());

    String json = objectMapper.writeValueAsString(person);
    System.out.println(json);
  }
}