package de.springbootbuch.extconfig;

import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private final String someValue;

    private final ExampleConfiguration exampleConfiguration;

    public ExampleService(@Value("${someValue:-1}") String someValue, ExampleConfiguration exampleConfiguration) {
        this.someValue = someValue;
        this.exampleConfiguration = exampleConfiguration;
    }

    public void printConfiguration(final PrintStream printWriter) {
        printWriter.println("someValue=" + this.someValue);
        printWriter.println("exampleConfiguration=" + this.exampleConfiguration);
    }
}
