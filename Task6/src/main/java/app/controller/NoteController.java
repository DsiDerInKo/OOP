package app.controller;

import app.controller.subcommands.Change;
import app.controller.subcommands.GetNote;
import app.controller.subcommands.Remove;
import app.controller.subcommands.SaveNote;
import app.note.EnvironmentalProvider;
import app.note.Note;
import app.note.interfaces.Controller;
import app.note.interfaces.Service;
import picocli.CommandLine;

import java.util.Date;

@CommandLine.Command(name = "controller", version = "controller 1.0",
        description = "wow", subcommands = {SaveNote.class,
        Remove.class,
        GetNote.class,
        Change.class})
public class NoteController implements Controller {

    Service service = EnvironmentalProvider.getService();

    @CommandLine.Option(names = {"sn", "saveNote"}, description = "default")
    private final boolean save = false;
    @CommandLine.Option(names = {"gv", "getNote"}, description = "default")
    private final boolean get = false;
    @CommandLine.Option(names = {"ct", "changeText"}, description = "default")
    private final boolean changeT = false;
    @CommandLine.Option(names = {"ch", "changeHeader"}, description = "default")
    private final boolean changeH = false;
    @CommandLine.Option(names = {"ra", "removeAll"}, description = "default")
    private final boolean removeA = false;
    @CommandLine.Option(names = {"rn", "removeNote"}, description = "default")
    private final boolean remove = false;

    public Integer call() throws Exception { // your business logic goes here...
        if (save) {

        }
        return 0;
    }


}
