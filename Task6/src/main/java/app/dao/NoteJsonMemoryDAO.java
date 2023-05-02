package app.dao;

import app.note.Note;
import app.note.interfaces.NoteDAO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class NoteJsonMemoryDAO implements NoteDAO {

    @Override
    public Note add(Note card) {

        try {
            // create a map
            Map<String, Object> map = new HashMap<>();
            map.put("Header", card.getHeader());
            map.put("Text", card.getText());
            map.put("Date", card.getDate());

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert map to JSON file
            String name = card.getHeader() + ".json";
            mapper.writeValue(Paths.get(name).toFile(), map);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Note delete(String header) {
        File file = new File(header+".txt");
        file.delete();
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Note> getNote(String header) {
        return Optional.empty();
    }

    @Override
    public Note updateNote(String header, Note newNote) {
        return null;
    }

    @Override
    public List<Note> getNotes() {
        return null;
    }
}
