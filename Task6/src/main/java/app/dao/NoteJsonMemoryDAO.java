package app.dao;

import app.note.Note;
import app.note.interfaces.NoteDAO;

import java.util.List;
import java.util.Optional;

public class NoteJsonMemoryDAO implements NoteDAO {

    @Override
    public Note add(Note card) {
        return null;
    }

    @Override
    public Note delete(String header) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Note> getNote(String header) {
        return Optional.empty();
    }

    @Override
    public Note updateNote(String header, Note newNote) {
        return null;
    }

    @Override
    public List<Note> getNotes() {
        return null;
    }
}
