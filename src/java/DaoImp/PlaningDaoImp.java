/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.PlaningDao;
import bo.NoteExaman;
import bo.NoteIntero;
import bo.Planing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class PlaningDaoImp implements PlaningDao{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private void initi(Planing old,Planing newO){
        old.setDate(newO.getDate());
        old.setModule(newO.getModule());
    }

    @Override
    public long save(Planing p) {
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
            Planing e = (Planing) s.get(Planing.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Planing p, long id) {
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Planing old = (Planing) s.get(Planing.class, id);
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
    public Planing getByEtud(long id) {
        Session s = null;
      Transaction t = null;
      Planing planing = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            planing = (Planing)s.createQuery("from planing where idEtudient='"+id+"'").uniqueResult();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return planing; //To change body of generated methods, choose Tools | Templates.
    }
    
}
