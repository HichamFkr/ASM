/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.NoteExamanDao;
import bo.Note;
import bo.NoteExaman;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class NoteExamanDaoImp implements NoteExamanDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void initia(NoteExaman old,NoteExaman newO){
     old.setDescription(newO.getDescription());
     old.setModule(newO.getModule());
     old.setNote(newO.getNote());
    }

    @Override
    public long save(NoteExaman n) {
        Session s = null;
        Transaction t = null;
        long id = 0;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            id = (long) s.save(n);
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
            NoteExaman e = (NoteExaman) s.get(NoteExaman.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(NoteExaman n, long id) {
        Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            NoteExaman old = (NoteExaman) s.get(NoteExaman.class, id);
            initia(old, n);
            s.update(old);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NoteExaman getNoteExaman(long id) {
         Session s = null;
      Transaction t = null;
      NoteExaman note = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            note = (NoteExaman)s.createQuery("from noteExaman where idEtudient='"+id+"'").uniqueResult();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return note; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<NoteExaman> getByGroupe(long id) {
         Session s = null;
      Transaction t = null;
      ArrayList<NoteExaman> list = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<NoteExaman>)s.createQuery("from noteExaman where idGroupe='"+id+"'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
    
}
