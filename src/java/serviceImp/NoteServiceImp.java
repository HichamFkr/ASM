/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.NoteDao;
import bo.Note;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NoteService;

/**
 *
 * @author Hicham
 */
@Service
public class NoteServiceImp implements NoteService{
    @Autowired
    private NoteDao noteIDao;

    public void setNoteIDao(NoteDao noteIDao) {
        this.noteIDao = noteIDao;
    }

    
    
    
    @Override
    public long save(Note n) {
        return noteIDao.save(n);
    }

    @Override
    public void delete(long id) {
        noteIDao.delete(id);
    }

    @Override
    public void update(Note n, long id) {
        noteIDao.update(n, id);
    }

    @Override
    public Note getByEtud(long id) {
        return noteIDao.getByEtud(id);
    }

    @Override
    public ArrayList<Note> getByGroupe(long id) {
        return noteIDao.getByGroupe(id);
    }
    
}
