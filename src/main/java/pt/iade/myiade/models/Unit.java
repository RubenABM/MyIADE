package pt.iade.myiade.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Unit")
public class Unit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="unit_id") private int id;
    @Column(name="unit_name") private String name;
    public Unit() {}
    public int getId() { return id; }
    public String getName() { return name; }
}