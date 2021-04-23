package edu.bsu.cs;

import com.google.inject.AbstractModule;
import edu.bsu.cs.model.Formatter;
import edu.bsu.cs.view.AlternateFormatter;

public class FormatModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(Formatter.class).to(AlternateFormatter.class);
    }
}
