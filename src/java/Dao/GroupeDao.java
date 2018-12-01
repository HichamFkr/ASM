/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Groupe;

/**
 *
 * @author prive
 */
public interface GroupeDao {
    
    long save(Groupe g);
    void delete(long id);
    void update(Groupe g,long id);
}
