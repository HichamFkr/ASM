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
public class Module implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomModule;
    @OneToOne
    @JoinColumn(name = "idEtudient") 
    private Etudient etudient;
    @OneToOne
    @JoinColumn(name = "idEnsignement")
    private Ensignement ensignement;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public Etudient getEtudient() {
        return etudient;
    }

    public void setEtudient(Etudient etudient) {
        this.etudient = etudient;
    }

    public Ensignement getEnsignement() {
        return ensignement;
    }

    public void setEnsignement(Ensignement ensignement) {
        this.ensignement = ensignement;
    }
    
    
}
