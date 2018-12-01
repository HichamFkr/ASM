/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Etudient;
import java.util.ArrayList;

/**
 *
 * @author prive
 */
public interface EtudientDao {
    
    long save(Etudient e);
    void delete(long id);
    void upDate(Etudient e,long id);
    ArrayList<Etudient> getByGroupe(long id);
    ArrayList<Etudient > getByEns(long idEnsi);
    
}
