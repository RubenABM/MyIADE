package pt.iade.myiade.models;
import java.time.LocalDate;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Student {
    private int id;
    private String name;
    private LocalDate birthDay;
    private String address;
    private String email;
    private char gender;
    private String className;

    @JsonIgnoreProperties({"student"})
    private ArrayList<Enrolment> enrolments;
    public Student(int id, String name, LocalDate birthDate, 
        String address, String email, char gender, String className) {
            this.id = id;
            this.name = name; 
            this.birthDay = birthDate;
            this.address = address;
            this.email = email;
            this.gender = gender;
            this.className = className;
            enrolments = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    

}
