/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.PlaningDao;
import bo.Planing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PlaningService;

/**
 *
 * @author Hicham
 */
@Service
public class PlaningServiceImp implements PlaningService{
    @Autowired
    private PlaningDao planingDao;

    public void setPlaningDao(PlaningDao planingDao) {
        this.planingDao = planingDao;
    }

    
    
    
    @Override
    public long save(Planing p) {
        return planingDao.save(p);
    }

    @Override
    public void delete(long id) {
        planingDao.delete(id);
    }

    @Override
    public void update(Planing p, long id) {
        planingDao.update(p, id);
    }

    @Override
    public Planing getByEtud(long id) {
       return planingDao.getByEtud(id);
    }
    
}
