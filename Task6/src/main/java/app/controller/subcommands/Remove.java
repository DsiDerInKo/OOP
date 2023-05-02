package app.controller.subcommands;

import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.Service;
import picocli.CommandLine;

import java.util.Date;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", version = "remove 1.0",
        description = "default")
public class Remove implements Callable {

    Service service = EnvironmentalProvider.getService();

    @CommandLine.Option(names = {"-h", "-header"}, description = "Note header")
    private String noteHeader;

    public Integer call() throws Exception { // your business logic goes here...
        service.remove(noteHeader);
        return 0;
    }
}
