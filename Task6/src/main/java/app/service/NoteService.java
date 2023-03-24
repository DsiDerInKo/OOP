package app.service;

import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.NoteDAO;
import app.note.interfaces.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class NoteService implements Service {

    NoteDAO dao = EnvironmentalProvider.getNoteDAO();

    @Override
    public Note save(Note card) {
        return dao.add(card);
    }

    @Override
    public List<Note> save(Collection<Note> cards) {
        return null;
    }

    @Override
    public Optional<Note> remove(String header) {
        return Optional.of(dao.delete(header));
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
    public Optional<Note> changeHeader(String header, String newHeader) {
        return Optional.of(dao.updateNote(header, new Note(newHeader, dao.getNote(header).get().getText())));
    }

    @Override
    public Optional<Note> changeText(String header, String newText) {
        return Optional.of(dao.updateNote(header, new Note(header, newText)));
    }

    @Override
    public List<Note> getNotes(boolean flag) {

        return dao.getNotes();
    }

    @Override
    public boolean sortNotes() {

        return false;
    }
}
