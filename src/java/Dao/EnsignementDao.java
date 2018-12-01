/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Ensignement;
import bo.Etudient;
import java.util.ArrayList;

/**
 *
 * @author prive
 */
public interface EnsignementDao {
    
    long save(Ensignement e);
    void delete(long id);
    void upDate(Ensignement e,long id);
    
}
