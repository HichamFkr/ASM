/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.ModuleDao;
import bo.Groupe;
import bo.Module;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class ModuleDaoImp implements ModuleDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private void initi(Module old,Module newO){
        old.setEnsignement(newO.getEnsignement());
        old.setEtudient(newO.getEtudient());
        old.setNomModule(newO.getNomModule());
    }
    @Override
    public long save(Module m) {
       Session s = null;
        Transaction t = null;
        long id = 0;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            id = (long) s.save(m);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        } finally {
            s.close();
        }
        return id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Module e = (Module) s.get(Module.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Module m, long id) {
        Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Module old = (Module) s.get(Module.class, id);
            initi(old, m);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Module> getByEtud(long id) {
       Session s = null;
      Transaction t = null;
      ArrayList<Module> list = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<Module>)s.createQuery("from module where idEtudient='"+id+"'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return list;
    }

    @Override
    public ArrayList<Module> getByEns(long id) {
        Session s = null;
      Transaction t = null;
      ArrayList<Module> list = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<Module>)s.createQuery("from module where idEnsignement='"+id+"'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
