package app.note.test;

import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.NoteDAO;
import app.note.interfaces.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNoteDAO {

    @Test
    void test() {

        NoteDAO dao = EnvironmentalProvider.getNoteDAO();

        Assertions.assertNull(dao.delete("aboba"));
        Assertions.assertNull(dao.getNotes());
        Assertions.assertNull(dao.changeHeader("1", "2"));
        Assertions.assertNull(dao.add(null));

        Note note1 = new Note("123", "asdasdasdasdasdasd");
        Note note2 = new Note("321", "asdasdasdasdasdasd");
        Assertions.assertNotNull(dao.add(note1));
        Assertions.assertEquals(note1, dao.getNote(note1.getHeader()).orElse(null));
        Assertions.assertNotEquals(note2, dao.getNote(note1.getHeader()).orElse(null));

        dao.deleteAll();
        Assertions.assertTrue(dao.getNotes().isEmpty());
    }
}
