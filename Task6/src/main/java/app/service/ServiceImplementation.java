package app.service;

import app.note.Note;
import app.note.interfaces.Service;

import java.util.List;
import java.util.Optional;

public class ServiceImplementation implements Service {

    @Override
    public Note save(Note card) {
        return null;
    }

    @Override
    public Note remove(String header) {
        return null;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public Optional<Note> getCard(String header) {
        return Optional.empty();
    }

    @Override
    public boolean exists(String header) {
        return false;
    }

    @Override
    public Note changeHeader(String header, String newHeader) {
        return null;
    }

    @Override
    public List<Note> getNotes(boolean flag) {
        return null;
    }

    @Override
    public boolean sortCards() {
        return false;
    }
}
