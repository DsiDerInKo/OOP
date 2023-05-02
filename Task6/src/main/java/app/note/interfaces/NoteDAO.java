package app.note.interfaces;

import app.note.Note;

import java.util.List;
import java.util.Optional;

public interface NoteDAO {

    Note add(Note card);

    Note delete(String header);

    void deleteAll();

    Optional<Note> getNote(String header);

    Note updateNote(String header, Note newNote);

    List<Note> getNotes();  //    ???  (get specified List of Entity
    //                                                        grouped by some condition)


}
