package edu.bsu.cs.view;

import edu.bsu.cs.model.Formatter;
import edu.bsu.cs.model.Revision;
import java.time.format.DateTimeFormatter;

//Class may be considered "unused" after implementing AlternateFormatter.
@SuppressWarnings("unused")
public final class RevisionFormatter implements Formatter {

    @Override
    public String format(Revision revision) {
        return String.format("At %s, a change by %s",
                DateTimeFormatter.ISO_INSTANT.format(revision.timestamp),
                revision.name);
    }
}
