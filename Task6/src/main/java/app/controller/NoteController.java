package app.controller;

import app.note.Note;
import app.note.interfaces.Controller;
import picocli.CommandLine;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Date;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "getNote", version = "getNote 1.0",
        description = "takes from CL new Note")
public class NoteController implements Controller {

    public Note note;

    @Override
    public Note getNote() throws Exception {
        call();
        return note;
    }

    @CommandLine.Option(names = {"-h","-header"}, description = "Note header")
    private String noteHeader;

    @CommandLine.Option(names = {"-t", "-text"}, description = "Note text")
    private String noteText;


    public Integer call() throws Exception { // your business logic goes here...
        note = new Note(noteHeader,noteText,new Date());
        return 0;
    }



}
