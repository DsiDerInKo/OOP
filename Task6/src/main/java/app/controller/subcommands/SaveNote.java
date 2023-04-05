package app.controller.subcommands;

import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.Service;
import picocli.CommandLine;

import java.util.Date;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "saveNote", version = "saveNote 1.0",
        description = "takes from CL new Note and saves it")
public class SaveNote implements Callable {
    Service service = EnvironmentalProvider.getService();

    @CommandLine.Option(names = {"-h", "-header"}, description = "Note header")
    private String noteHeader;

    @CommandLine.Option(names = {"-t", "-text"}, description = "Note text")
    private String noteText;

    public Integer call() throws Exception { // your business logic goes here...
        service.save(new Note(noteHeader, noteText, new Date()));
        return 0;
    }
}
