/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.NoteIntroDao;
import bo.NoteExaman;
import bo.NoteIntero;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class NoteInteroDaoImp implements NoteIntroDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void initi(NoteIntero old,NoteIntero newO){
        old.setDescription(newO.getDescription());
        old.setEtudient(newO.getEtudient());
        old.setModule(newO.getModule());
        old.setNote(newO.getNote());
    }
    
    @Override
    public long save(NoteIntero noteIntero) {
       Session s = null;
        Transaction t = null;
        long id = 0;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            id = (long) s.save(noteIntero);
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
            NoteIntero e = (NoteIntero) s.get(NoteIntero.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(NoteIntero n, long id) {
        Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            NoteIntero old = (NoteIntero) s.get(NoteIntero.class, id);
            initi(old, n);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NoteIntero> getByEtudient(long id) {
         Session s = null;
      Transaction t = null;
      ArrayList<NoteIntero> list = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<NoteIntero>)s.createQuery("from noteIntero where idEtudient='"+id+"'").list();
        } catch (Exception e) {
            
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NoteIntero> getByGroupe(long id) {
           Session s = null;
      Transaction t = null;
      ArrayList<NoteIntero> list = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<NoteIntero>)s.createQuery("from noteIntero where idGroupe='"+id+"'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    
}
