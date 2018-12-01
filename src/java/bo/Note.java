/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import java.io.Serializable;
import javax.annotation.Generated;
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
public class Note implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "idEtudient")
    private Etudient etudient;
    @OneToOne
    @JoinColumn(name = "idNoteIntero")
    private NoteIntero noteIntero;
    @OneToOne
    @JoinColumn(name = "idNoteExaman")
    private NoteExaman noteExaman;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Etudient getEtudient() {
        return etudient;
    }

    public void setEtudient(Etudient etudient) {
        this.etudient = etudient;
    }

    public NoteIntero getNoteIntero() {
        return noteIntero;
    }

    public void setNoteIntero(NoteIntero noteIntero) {
        this.noteIntero = noteIntero;
    }

    public NoteExaman getNoteExaman() {
        return noteExaman;
    }

    public void setNoteExaman(NoteExaman noteExaman) {
        this.noteExaman = noteExaman;
    }
    
}
