package dirapp.java_dasar_json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

// Serialization (mengubah object menjadi format data yang bisa disimpan, seperti JSON, XML, dll)
// Deserialization (mengubah format data seperti JSON menjadi Object)

// @JsonIgnoreProperties(ignoreUnknown = true) // jika ini true, maka ketika ada field yg tidak ada dari hasil pembacaan JSON, akan otomatis diisikan NULL, dan tidak memunculkan error
public class Person {

    private String id;

    private String name;

    @JsonProperty("full_name") // mengubah attribute ketika proses serialization dan deserialization
    private String fullName;

    @JsonIgnore // menandai sebuah field yg akan diIgnore saat proses serialization dan deserialization
    private String password;

    private List<String> hobbies;

    private Address address;

    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd") // mengubah format data (misal date time) ketika proses serialization dan deserialization
    private Date updatedAt;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
