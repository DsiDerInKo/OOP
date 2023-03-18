package app.note.interfaces;

import app.note.Note;

import java.util.List;
import java.util.Optional;

public interface Service {

    Note save(Note card);

    Note remove(String header);

    void removeAll();

    Optional<Note> getCard(String header);

    boolean exists(String header);

    Note changeHeader(String header, String newHeader);

    List<Note> getNotes(boolean flag);  //    ???  (get specified List of Entity
    //          grouped by some condition)


    boolean sortCards();  // sort in list by alphabet/tag/date

}
