package pt.iade.myiade.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Course {
    private int id;
    private String[] unit;
    private String name;

    @JsonIgnoreProperties({"course"})
    private ArrayList<Enrolment> enrolments;
    
    public Course(int id, String[] unit, String name) {
        this.id = id;
        this.unit = unit;
        this.name = name;
        enrolments = new ArrayList<Enrolment>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getUnit() {
        return unit;
    }

    public void setUnit(String[] unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
