/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.PlaningExamanDao;
import bo.Module;
import bo.NoteExaman;
import bo.Planing;
import bo.PlaningExaman;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class PlaningExamanDaoImp implements PlaningExamanDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void initi(PlaningExaman old,PlaningExaman newO){
        old.setDate(newO.getDate());
        old.setModule(newO.getModule());
        
    }

    @Override
    public long save(PlaningExaman p) {
       Session s = null;
        Transaction t = null;
        long id = 0;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            id = (long) s.save(p);
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
            PlaningExaman e = (PlaningExaman) s.get(PlaningExaman.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PlaningExaman p, long id) {
       Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            PlaningExaman old = (PlaningExaman) s.get(Module.class, id);
            initi(old, p);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlaningExaman getByEtud(long id) {
          Session s = null;
      Transaction t = null;
      PlaningExaman planingExaman = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            planingExaman = (PlaningExaman)s.createQuery("from noteExaman where idGroupe='"+id+"'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return planingExaman; //To change body of generated methods, choose Tools | Templates.
    }
    
}
