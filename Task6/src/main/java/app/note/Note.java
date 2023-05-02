package app.note;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Note {

    private String header;
    private String text;
    private Date date;

    public Note(String header, String text, Date date) {
        this.header = header;
        this.text = text;
        this.date = date;
    }

    public Note(String header, String text) {
        this(header, text, new Date());
    }


}

