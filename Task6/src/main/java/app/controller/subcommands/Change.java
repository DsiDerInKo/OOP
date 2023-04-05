package app.controller.subcommands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "change", version = "change 1.0",
        description = "default")
public class Change implements Callable {

    public Integer call() throws Exception { // your business logic goes here...

        return 0;
    }
}
