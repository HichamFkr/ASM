/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.GroupeDao;
import bo.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GroupeService;

/**
 *
 * @author Hicham
 */
@Service
public class GroupeServiceImp implements GroupeService{
    @Autowired
    
    private GroupeDao groupeDao;

    public void setGroupeDao(GroupeDao groupeDao) {
        this.groupeDao = groupeDao;
    }

    
    
    
    
    @Override
    public long save(Groupe g) {
        return groupeDao.save(g);
    }

    @Override
    public void delete(long id) {
        groupeDao.delete(id);
    }

    @Override
    public void update(Groupe g, long id) {
        groupeDao.update(g, id);
    }
    
}
