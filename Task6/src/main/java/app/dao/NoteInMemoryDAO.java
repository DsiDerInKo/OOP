package app.dao;

import app.note.Note;
import app.note.interfaces.NoteDAO;

import java.util.*;

public class NoteInMemoryDAO implements NoteDAO {

    private final Map<String, Note> base;

    public NoteInMemoryDAO() {
        base = new HashMap<String, Note>();
    }

    @Override
    public Note add(Note card) {
        base.put(card.getHeader(), card);
        return card;
    }

    @Override
    public Note delete(String header) {
        return base.remove(header);
    }

    @Override
    public void deleteAll() {
        base.clear();
    }

    @Override
    public Optional<Note> getNote(String header) {
        return Optional.of(base.get(header));
    }

    @Override
    public Note updateNote(String header, Note newNote) {
        base.get(header).setHeader(newNote.getHeader());
        base.get(header).setDate(newNote.getDate());
        return null;
    }

    @Override
    public List<Note> getNotes() {
        return new LinkedList<Note>(base.values());
    }
}
