package app.note;

import app.note.interfaces.Controller;
import app.dao.NoteInMemoryDAO;
import app.note.interfaces.NoteDAO;
import app.note.interfaces.Service;

/**
 * Dependency injection
 */
public class EnvironmentalProvider {

    static public NoteDAO getNoteDAO() {
        return new NoteInMemoryDAO();
    }

    static public Service getService() {
        return (Service) new Object(); //new app.note.interfaces.Service();
    }

    static public Controller getController(){return (Controller) new Object();}
}
