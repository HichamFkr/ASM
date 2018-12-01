/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.NoteExaman;
import java.util.ArrayList;

/**
 *
 * @author prive
 */
public interface NoteExamanDao {
    
    long save(NoteExaman n);
    void delete(long id);
    void update(NoteExaman n,long id);
    NoteExaman getNoteExaman(long id);
    ArrayList<NoteExaman> getByGroupe(long id);
}
