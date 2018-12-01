/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Note;
import java.util.ArrayList;

/**
 *
 * @author prive
 */
public interface NoteDao {
 
    long save(Note n);
    void delete(long id);
    void update(Note n,long id);
    Note getByEtud(long id);
    ArrayList<Note> getByGroupe(long id);
}
