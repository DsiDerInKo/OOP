package app.dao;

import app.note.Note;
import app.note.interfaces.NoteDAO;

import java.util.*;

public class DAOImplementation implements NoteDAO {

    private final Map<String,Note> base;

    public DAOImplementation(){
        base = new HashMap<String,Note>();
    }

    @Override
    public Note add(Note card) {
        base.put(card.getHeader(),card);
        return card;
    }

    @Override
    public Note delete(String header) {
        return base.remove(header);
    }

    @Override
    public void deleteAll() {
        base.forEach((key, value)->base.remove(key));
    }

    @Override
    public Optional<Note> getNote(String header) {
        return Optional.of(base.get(header));
    }

    @Override
    public Note changeHeader(String header, String newHeader) {
        Note tmp = base.remove(header);
        tmp.setHeader(newHeader);
        return base.put(newHeader,tmp);
    }

    @Override
    public List<Note> getNotes() {
        List<Note> list = new LinkedList<Note>();
        base.forEach((key, value)-> list.add(base.get(key)));
        return list;
    }
}
