package app.service;

import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.NoteDAO;
import app.note.interfaces.Service;

import java.util.List;
import java.util.Optional;

public class NoteService implements Service {

    NoteDAO dao = EnvironmentalProvider.getNoteDAO();

    @Override
    public Note save(Note card) {
        return dao.add(card);
    }

    @Override
    public Note remove(String header) {
        return dao.delete(header);
    }

    @Override
    public void removeAll() {
        dao.deleteAll();
    }

    @Override
    public Optional<Note> getNote(String header) {
        return dao.getNote(header);
    }

    @Override
    public boolean exists(String header) {
        return dao.getNote(header).isPresent();
    }

    @Override
    public Note changeHeader(String header, String newHeader) {
        return dao.update(header,new Note(newHeader,dao.getNote(header).get().getText()));
    }

    @Override
    public Note changeText(String header, String newText) {
        return dao.update(header,new Note(header,newText));
    }

    @Override
    public Note changeText(String header, String newText) {
        return null;
    }

    @Override
    public List<Note> getNotes(boolean flag) {

        return null;
    }

    @Override
    public boolean sortNotes() {
        return false;
    }
}
