/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.EnsignementDao;
import bo.Ensignement;
import bo.Etudient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author prive
 */
public class EnsignementDaoImp implements EnsignementDao{
    
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void initia(Ensignement old,Ensignement newE){
        old.setEmail(newE.getEmail());
        old.setNom(newE.getNom());
        old.setPrenom(newE.getPrenom());
    }
    @Override
    public long save(Ensignement e) {
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
        return id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
      Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Ensignement e = (Ensignement) s.get(Ensignement.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upDate(Ensignement e, long id) {
        Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Ensignement old = (Ensignement) s.get(Ensignement.class, id);
            initia(old, e);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }
    
}
