/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.EnsignementDao;
import bo.Ensignement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EnseignantService;

/**
 *
 * @author Hicham
 */
@Service
public class EnseignantServiceImp implements EnseignantService{
    @Autowired
    private EnsignementDao enseignantDao;

    public void setEnseignantDao(EnsignementDao enseignantDao) {
        this.enseignantDao = enseignantDao;
    }

    
    
   
    
    @Override
    public long save(Ensignement e) {
           return enseignantDao.save(e);
    }

    @Override
    public void delete(long id) {
        enseignantDao.delete(id);
    }

    @Override
    public void upDate(Ensignement e, long id) {
        enseignantDao.upDate(e, id);
    }
    
}
