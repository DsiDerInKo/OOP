package app.controller;

import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.Controller;
import app.note.interfaces.Service;
import picocli.CommandLine;

import java.util.Date;

public class NoteController implements Controller {

    Service service = EnvironmentalProvider.getService();

    @CommandLine.Command(name = "saveNote", version = "getNote 1.0",
            description = "takes from CL new Note and saves it")
    class saveNote {
        @CommandLine.Option(names = {"-h", "-header"}, description = "Note header")
        private String noteHeader;

        @CommandLine.Option(names = {"-t", "-text"}, description = "Note text")
        private String noteText;


        public Integer call() throws Exception { // your business logic goes here...
            service.save(new Note(noteHeader, noteText, new Date()));
            return 0;
        }
    }

    class removeNote {
        @CommandLine.Option(names = {"-h", "-header"}, description = "Note header")
        private String noteHeader;

        public Integer call() throws Exception { // your business logic goes here...
            service.remove(noteHeader);
            return 0;
        }
    }

    class removeAll {

    }

    class changeHeader {

    }

    class changeText {

    }

    class getNote {

        @CommandLine.Option(names = {"-h", "-header"}, description = "Note header")
        private String noteHeader;

        public Integer call() throws Exception { // your business logic goes here...
            service.getNote(noteHeader).ifPresent(System.out::println);
            return 0;
        }
    }

}
