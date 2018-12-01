/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author prive
 */
@Entity
@Table 
public class NoteIntero implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private double note;
    @OneToOne
    @JoinColumn(name = "idModule")
    private Module module;
      @OneToOne
    @JoinColumn(name = "idEtudient")
    private Etudient etudient;

    public Etudient getEtudient() {
        return etudient;
    }

    public void setEtudient(Etudient etudient) {
        this.etudient = etudient;
    }
      
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
    
    
}
