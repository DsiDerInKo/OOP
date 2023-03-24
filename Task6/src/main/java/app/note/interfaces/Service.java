package app.note.interfaces;

import app.note.Note;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Service {

    Note save(Note card);

    List<Note> save(Collection<Note> cards);

    Optional<Note> remove(String header);

    void removeAll();

    Optional<Note> getNote(String header);

    boolean exists(String header);

    Optional<Note> changeHeader(String header, String newHeader);

    Optional<Note> changeText(String header, String newText);

    List<Note> getNotes(boolean flag);  //    ???  (get specified List of Entity
    //          grouped by some condition)


    boolean sortNotes();  // sort in list by alphabet/tag/date


}
