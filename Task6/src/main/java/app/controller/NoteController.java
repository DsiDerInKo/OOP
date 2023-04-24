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


import java.util.concurrent.Callable;

@CommandLine.Command(name = "notebook", version = "controller 1.0",
        description = "wow", subcommands = {SaveNote.class,
        Remove.class,
        GetNote.class,
        Change.class})
public class NoteController implements Callable {

    //Service service = EnvironmentalProvider.getService();

//    @CommandLine.Option(names = {"sn", "saveNote"}, description = "default")
//    private boolean save = false;
//    @CommandLine.Option(names = {"gv", "getNote"}, description = "default")
//    private boolean get = false;
//    @CommandLine.Option(names = {"ct", "changeText"}, description = "default")
//    private boolean changeT = false;
//    @CommandLine.Option(names = {"ch", "changeHeader"}, description = "default")
//    private boolean changeH = false;
//    @CommandLine.Option(names = {"ra", "removeAll"}, description = "default")
//    private boolean removeA = false;
//    @CommandLine.Option(names = {"rn", "removeNote"}, description = "default")
//    private boolean remove = false;

    public Integer call() throws Exception { // your business logic goes here...

        //commandLine.execute();

        return 0;
    }

    public static void main(String... args) {

        int exitCode = new CommandLine(new NoteController())
                .addSubcommand("save", new SaveNote())
                .addSubcommand("remove", new Remove())
                .addSubcommand("get", new GetNote())
                .addSubcommand("change", new Change())
                .execute(args);
        System.exit(exitCode);
    }
}