/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.EtudientDao;
import bo.Etudient;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class EtudientDaoImp implements EtudientDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    private void initialiser(Etudient old,Etudient newE){
        old.setDateNaissance(newE.getDateNaissance());
        old.setGroupe(newE.getGroupe());
        old.setMatricule(newE.getMatricule());
        old.setNom(newE.getNom());
        old.setPrenom(newE.getPrenom());
        old.setPlanigExman(newE.getPlanigExman());
        old.setPlaning(newE.getPlaning());
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public long save(Etudient e) {
        Session s = null; 
        Transaction t = null;
        long id = 0;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            id = (long) s.save(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
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
            Etudient e = (Etudient) s.get(Etudient.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } 
    }

    @Override
    public void upDate(Etudient e, long id) {
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Etudient old = (Etudient) s.get(Etudient.class, id);
            initialiser(old, e);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Etudient> getByGroupe(long id) {
       ArrayList<Etudient> list = null;
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<Etudient>) s.createQuery("from etudient where idGroupe ='"+id+"'").list();
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } 
       return list;
    }

    @Override
    public ArrayList<Etudient> getByEns(long idEnsi) {
       ArrayList<Etudient> list = null;
         Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<Etudient>) s.createQuery("from etudient where idEnsignement ='"+idEnsi+"'").list();
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } 
       return list; //To change body of generated methods, choose Tools | Templates.
    }
    
}
