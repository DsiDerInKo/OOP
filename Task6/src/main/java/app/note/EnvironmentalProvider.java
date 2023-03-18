package app.note;

import app.note.interfaces.NoteDAO;
import app.note.interfaces.Service;

public class EnvironmentalProvider {

    static public NoteDAO getNoteDAO() {
        return (NoteDAO) new Object();
    }

    static public Service getService() {
        return (Service) new Object(); //new app.note.interfaces.Service();
    }

}
