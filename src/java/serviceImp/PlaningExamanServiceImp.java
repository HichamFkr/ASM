/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.PlaningExamanDao;
import DaoImp.PlaningExamanDaoImp;
import bo.Planing;
import bo.PlaningExaman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PlaningExamanService;

/**
 *
 * @author Hicham
 */
@Service
public class PlaningExamanServiceImp implements PlaningExamanService{
    
    @Autowired
    private PlaningExamanDao planingExamanDao;

    public void setPlaningExamanDao(PlaningExamanDao planingExamanDao) {
        this.planingExamanDao = planingExamanDao;
    }

   
    
    
    public long save(PlaningExaman p) {
        return planingExamanDao.save(p);
    }

    @Override
    public void delete(long id) {
        planingExamanDao.delete(id);
    }

    public void update(PlaningExaman p, long id) {
        planingExamanDao.update(p, id);
    }

    @Override
    public PlaningExaman getByEtud(long id) {
       return planingExamanDao.getByEtud(id); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
