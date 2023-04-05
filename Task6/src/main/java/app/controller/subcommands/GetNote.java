package app.controller.subcommands;

import app.note.EnvironmentalProvider;
import app.note.interfaces.Service;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "get", version = "getNote 1.0",
        description = "takes from data")
public class GetNote implements Callable {
    Service service = EnvironmentalProvider.getService();

    @CommandLine.Option(names = {"-h", "-header"}, description = "Note header")
    private String noteHeader;

    public Integer call() throws Exception { // your business logic goes here...
        service.getNote(noteHeader).ifPresent(System.out::println);
        return 0;
    }
}
