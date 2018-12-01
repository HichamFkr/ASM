/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceImp;

import Dao.NoteExamanDao;
import bo.NoteExaman;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NoteExamanService;

/**
 *
 * @author Hicham
 */
@Service
public class NoteExamanServiceImp implements  NoteExamanService{
    
    @Autowired
    private NoteExamanDao noteExamanDao;

    public void setNoteExamanDao(NoteExamanDao noteExamanDao) {
        this.noteExamanDao = noteExamanDao;
    }

    
    
        
    @Override
    public long save(NoteExaman n) {
        return noteExamanDao.save(n);
    }

    @Override
    public void delete(long id) {
        noteExamanDao.delete(id);
    }

    @Override
    public void update(NoteExaman n, long id) {
        noteExamanDao.update(n, id);
    }

    @Override
    public NoteExaman getNoteExaman(long id) {
        return  noteExamanDao.getNoteExaman(id);
    }

    @Override
    public ArrayList<NoteExaman> getByGroupe(long id) {
        return noteExamanDao.getByGroupe(id);
    }
    
}
