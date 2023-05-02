package app;

import app.controller.NoteController;
import app.controller.subcommands.Change;
import app.controller.subcommands.GetNote;
import app.controller.subcommands.Remove;
import app.controller.subcommands.SaveNote;
import app.note.EnvironmentalProvider;
import picocli.CommandLine;

public class Application {


    public static void main(String[] args) {
        NoteController noteController = EnvironmentalProvider.getController();

        int exitCode = new CommandLine(noteController)
                .execute(args);
        System.exit(exitCode);

    }
}
