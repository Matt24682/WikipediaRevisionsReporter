package edu.bsu.cs.view;

import edu.bsu.cs.model.Formatter;
import edu.bsu.cs.model.Revision;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

// This class may be considered "unused" because it is injected via Guice.
@SuppressWarnings("unused")
public class AlternateFormatter implements Formatter {

    public String format(Revision revision){
        return String.format("A change was made on %s by %s",
                DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm:ss")
                        .withZone(ZoneOffset.UTC).format(revision.timestamp),revision.name);
    }
}
