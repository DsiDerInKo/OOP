package app.controller.subcommands;

import app.note.Note;
import picocli.CommandLine;

import java.util.Date;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", version = "remove 1.0",
        description = "default")
public class Remove implements Callable {

    public Integer call() throws Exception { // your business logic goes here...

        return 0;
    }
}
