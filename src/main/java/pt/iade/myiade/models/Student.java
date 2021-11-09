package pt.iade.myiade.models;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="stu_id") private int id;
    @Column(name="stu_name") private String name;
    @Column(name="stu_bDate") private LocalDate bDate;
    @Column(name="stu_mobileNumber") private int mNumber;
    @Column(name="stu_email") private String email;
    @Column(name="stu_address") private String address;
    @Column(name="stu_rateCommentId") private int rateId;
    @Column(name="stu_subscriptionId") private int subId;
    @Column(name="stu_answerId") private int ansId;
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
    public int getMNumber() {   
        return mNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public int getRateId() {
        return RateId;
    }
    public int getSubId() {
        return subId;
    }
    public int getAnsId() {
        return ansId;
    } 
}
