package pt.iade.myiade.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students2")
public class Iade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="stu_id") private int id;
    @Column(name="stu_name") private String name;
    @Column(name="stu_bDate") private LocalDate bDate;
    @Column(name="stu_phone") private int phone;
    public Iade() {}
    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getBDate() { 
        return bDate; 
    }
    public int getPhone() {   
        return phone;
    }
}
