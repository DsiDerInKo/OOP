package app.dao;

import app.note.Note;
import app.note.interfaces.NoteDAO;

import java.util.*;

public class NoteInMemoryDAO implements NoteDAO {

    /**
     * place where notes contains
     */
    private final Map<String, Note> base;

    public NoteInMemoryDAO() {
        base = new HashMap<String, Note>();
    }

    /**
     * Takes card and saves
     *
     * @param card that will be saved in base
     * @return saved note
     */
    @Override
    public Note add(Note card) {
        base.put(card.getHeader(), card);
        return card;
    }

    /**
     * Deletes note by header
     *
     * @param header by which note will be deleted
     * @return deleted note
     */
    @Override
    public Note delete(String header) {
        return base.remove(header);
    }

    /**
     * Clears base
     */
    @Override
    public void deleteAll() {
        base.clear();
    }

    /**
     * Takes a note from base by header
     *
     * @param header by which note will be deleted
     * @return note by header
     */
    @Override
    public Optional<Note> getNote(String header) {
        return Optional.of(base.get(header));
    }

    /**
     * Rewrite note into new
     *
     * @param header  header by which note will be rewritten
     * @param newNote new note
     * @return Rewritten note
     */
    @Override
    public Note updateNote(String header, Note newNote) {
        base.get(header).setHeader(newNote.getHeader());
        base.get(header).setDate(newNote.getDate());
        return null;
    }

    /**
     * Gets list of every notes
     *
     * @return List of notes
     */
    @Override
    public List<Note> getNotes() {
        return new LinkedList<Note>(base.values());
    }
}
