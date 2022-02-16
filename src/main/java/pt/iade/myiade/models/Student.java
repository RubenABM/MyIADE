package pt.iade.myiade.models;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="stu_id") private int id;
    @Column(name="stu_name") private String name;
    @Column(name="stu_bDate") private LocalDate bDate;
    @Column(name="stu_phone") private String phone;
    @Column(name="stu_email") private String email;
    @Column(name="stu_address") private String address;
    @Column(name="stu_password") private String password;
    @Column(name="stu_gender") private char gender;
    @Column(name="stu_civilnum") private int civilNum;
    public Student() {}
    public int getId() { 
        return id;
    }
    public String getName() { 
        return name;
     }
    public LocalDate getBDate() { 
        return bDate; 
    }
    public String getPhone() {   
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }
    public char getGender() {
        return gender;
    }
    public int getCivilNumber() {
        return civilNum;
    } 
}
