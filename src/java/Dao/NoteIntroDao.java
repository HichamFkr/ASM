/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.NoteIntero;
import java.util.ArrayList;

/**
 *
 * @author prive
 */
public interface NoteIntroDao {
    
    long save(NoteIntero noteIntero);
    void delete(long id);
    void update(NoteIntero n,long id);
    ArrayList<NoteIntero> getByEtudient(long id);
    ArrayList<NoteIntero> getByGroupe(long id);
}
