package app.note;

import app.controller.NoteController;
import app.dao.NoteJsonMemoryDAO;
import app.note.interfaces.Controller;
import app.dao.NoteInMemoryDAO;
import app.note.interfaces.NoteDAO;
import app.note.interfaces.Service;
import app.service.NoteService;

/**
 * Dependency injection
 */
public class EnvironmentalProvider {

    static public NoteDAO getNoteDAO() {
        return new NoteJsonMemoryDAO();
    }

    static public Service getService() {
        return new NoteService(); //new app.note.interfaces.Service();
    }

    static public NoteController getController() {
        return new NoteController();
    }
}
