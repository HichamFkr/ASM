/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.PlaningExaman;

/**
 *
 * @author prive
 */
public interface PlaningExamanDao {
 
    long save(PlaningExaman p);
    void delete(long id);
    void update(PlaningExaman p,long id);
    PlaningExaman getByEtud(long id);
}
