/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Planing;

/**
 *
 * @author prive
 */
public interface PlaningDao {
    
    long save(Planing p);
    void delete(long id);
    void update(Planing p,long id);
    Planing getByEtud(long id);
}
