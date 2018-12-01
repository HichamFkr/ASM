/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImp;

import Dao.GroupeDao;
import bo.Ensignement;
import bo.Etudient;
import bo.Groupe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class GroupeDaoImp implements GroupeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void initi(Groupe old, Groupe newO) {
       old.setNomGroupe(newO.getNomGroupe());
    }

    @Override
    public long save(Groupe g) {
        Session s = null;
        Transaction t = null;
        long id = 0;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            id = (long) s.save(g);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        } finally {
            s.close();
        }
        return id;
    }

    @Override
    public void delete(long id) {
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Groupe e = (Groupe) s.get(Groupe.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Groupe g, long id) {
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Groupe old = (Groupe) s.get(Groupe.class, id);
            initi(old, g);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }   //To change body of generated methods, choose Tools | Templates.
    }

}
