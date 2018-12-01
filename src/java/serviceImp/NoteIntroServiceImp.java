/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import bo.NoteIntero;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NoteIntroService;

/**
 *
 * @author Hicham
 */
@Service
public class NoteIntroServiceImp implements NoteIntroService{
    @Autowired
    private NoteIntroService noteIntroDao;

    public NoteIntroService getNoteIntroDao() {
        return noteIntroDao;
    }

    public void setNoteIntroDao(NoteIntroService noteIntroDao) {
        this.noteIntroDao = noteIntroDao;
    }

    
    
    
    @Override
    public long save(NoteIntero noteIntero) {
        return noteIntroDao.save(noteIntero);
    }

    @Override
    public void delete(long id) {
        noteIntroDao.delete(id);
    }

    @Override
    public void update(NoteIntero n, long id) {
        noteIntroDao.update(n, id);
    }

    @Override
    public ArrayList<NoteIntero> getByEtudient(long id) {
        return noteIntroDao.getByEtudient(id);
    }

    @Override
    public ArrayList<NoteIntero> getByGroupe(long id) {
        return noteIntroDao.getByGroupe(id);
    }
    
}
