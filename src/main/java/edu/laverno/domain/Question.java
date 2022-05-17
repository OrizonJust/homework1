package edu.laverno.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

    private final String name;
    private final List<String> options;

    public Question(String name, String... options) {
        this.name = name;
        this.options = new ArrayList<>(Arrays.asList(options));
    }

    public String getName() {
        return name;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return name + ": 1." + options.get(0) + ", 2." + options.get(1) + ", 3." + options.get(2);
    }
}
