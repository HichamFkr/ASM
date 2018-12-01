/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoImp;

import Dao.NoteDao;
import bo.Module;
import bo.Note;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author prive
 */
public class NoteDaoImp implements NoteDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void initi(Note old,Note newO){
        old.setEtudient(newO.getEtudient());
        old.setNoteExaman(newO.getNoteExaman());
        old.setNoteIntero(newO.getNoteIntero());
    }

    @Override
    public long save(Note n) {
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
            Note e = (Note) s.get(Note.class, id);
            s.delete(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }finally{
            s.close();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Note n, long id) {
        Session s = null; 
        Transaction t = null;
        
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            Note old = (Note) s.get(Note.class, id);
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
    public Note getByEtud(long id) {
        Session s = null;
      Transaction t = null;
      Note note = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            note = (Note)s.createQuery("from note where idEtudient='"+id+"'").uniqueResult();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return note; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Note> getByGroupe(long id) {
         Session s = null;
      Transaction t = null;
      ArrayList<Note> list = null;
        try {
            s = sessionFactory.openSession();
            t = s.beginTransaction();
            list = (ArrayList<Note>)s.createQuery("from module where idGroupe='"+id+"'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return list; //To change body of generated methods, choose Tools | Templates.
    }
}
