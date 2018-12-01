/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.ModuleDao;
import bo.Module;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ModuleService;

/**
 *
 * @author Hicham
 */
@Service
public class ModuleServiceImp implements ModuleService{
    
    @Autowired
    
    private ModuleDao moduleDao;

    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }

   
    
    
    @Override
    public long save(Module m) {
        return moduleDao.save(m);
    }

    @Override
    public void delete(long id) {
        moduleDao.delete(id);
    }

    @Override
    public void update(Module m, long id) {
        moduleDao.update(m, id);
    }

    @Override
    public ArrayList<Module> getByEtud(long id) {
        return moduleDao.getByEtud(id);
    }

    @Override
    public ArrayList<Module> getByEns(long id) {
        return moduleDao.getByEns(id);
    }
    
}
