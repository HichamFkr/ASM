/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author prive
 */
@Entity
@Table(name = "etudient")
public class Etudient implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    @Column(name = "matricule",unique = true )
    private String matricule;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @OneToOne
    @JoinColumn(name = "idGroupe")
    private Groupe groupe;
    @OneToOne
    @JoinColumn(name = "idPlaningCours")
    private Planing planing;
    @OneToOne
    @JoinColumn(name = "idPlaningExaman")
    private PlaningExaman planigExman;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Planing getPlaning() {
        return planing;
    }

    public void setPlaning(Planing planing) {
        this.planing = planing;
    }

    public PlaningExaman getPlanigExman() {
        return planigExman;
    }

    public void setPlanigExman(PlaningExaman planigExman) {
        this.planigExman = planigExman;
    }
    
    
}
