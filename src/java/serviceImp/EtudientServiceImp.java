/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.EtudientDao;
import bo.Etudient;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EtudientService;

/**
 *
 * @author Hicham
 */
@Service
public class EtudientServiceImp implements EtudientService{
    @Autowired
    private EtudientDao etudientDao;

    public void setEtudientDao(EtudientDao etudientDao) {
        this.etudientDao = etudientDao;
    }

   
 
    @Override
    public long save(Etudient e) {
       return etudientDao.save(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        etudientDao.delete(id);
    }

    @Override
    public void upDate(Etudient e, long id) {
        etudientDao.upDate(e, id);
    }

    @Override
    public ArrayList<Etudient> getByGroupe(long id) {
        return etudientDao.getByGroupe(id);
    }

    @Override
    public ArrayList<Etudient> getByEns(long idEnsi) {
       return etudientDao.getByEns(idEnsi);
    }
    
    
    
}
