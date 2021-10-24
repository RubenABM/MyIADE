package pt.iade.myiade.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NomeTabela")
public class Iade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cour_id")
    private int id;
    @Column(name="cour_name")
    private String name;
    public Iade() {}
    
    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    
    
}
