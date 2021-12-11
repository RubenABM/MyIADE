package pt.iade.myiade.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="presences")
public class Presence {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pre_id") private int id;
    @Column(name="pre_date") private LocalDate presenceDate;
    @Column(name="pre_sche_id") private LocalDate presenceScheduleId;
    @Column(name="pre_stu_id") private int presenceStudentId;
    public Presence() {}
    public int getId() {
        return id;
    }
    public LocalDate getPresenceDate() {
        return presenceDate;
    }
    public LocalDate getPresenceScheduleId() {
        return presenceScheduleId;
    }
    public int getPresenceStudentId() {
        return presenceStudentId;
    }  
}
