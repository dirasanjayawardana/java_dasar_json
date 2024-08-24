package dirapp.java_dasar_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectMapperTest {
  // ObjectMapper adalah class di library Jackson sebagai class utama
  // ObjectMapper hanya perlu dibuat sekali dalam sebuah project, ObjectMapper sudah thread save


  @Test
  void createObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();

    Assertions.assertNotNull(objectMapper);
  }
}