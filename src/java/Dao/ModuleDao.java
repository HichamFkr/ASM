/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import bo.Module;
import java.util.ArrayList;

/**
 *
 * @author prive
 */
public interface ModuleDao {
 
    long save(Module m);
    void delete(long id);
    void update(Module m,long id);
    ArrayList<Module> getByEtud(long id);
    ArrayList<Module> getByEns(long id);
    
}
