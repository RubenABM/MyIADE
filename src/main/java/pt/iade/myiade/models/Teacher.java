package pt.iade.myiade.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="teach_id") private int id;
    @Column(name="teach_name") private String name;
    @Column(name="teach_phone") private int phone;
    @Column(name="teach_email") private String email;
    public Teacher() {}
    public int getId() { 
        return id;
    }
    public String getName() { 
        return name;
     }
    public int getPhone() {   
        return phone;
    }
    public String getEmail() {
        return email;
    }
}
