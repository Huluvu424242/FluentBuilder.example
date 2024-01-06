package com.github.huluvu424242.legacyperson;

public class LegacyPersonBuilder implements BuilderStages {


    LegacyPerson person;

    private LegacyPersonBuilder() {
        this.person = new LegacyPerson();
    }

    public LegacyPerson getPerson() {
        return person;
    }

    public static NewStage builder() {
        final LegacyPersonBuilder builder = new LegacyPersonBuilder();
        return () -> builder.person;
    }

}
