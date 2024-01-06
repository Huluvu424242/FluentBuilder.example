package com.github.huluvu424242.stagedperson;


import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;


@Getter
public class StagedPerson {

    StagedPerson() {
    }

    protected double birthWeight;
    protected LocalDate birthday;
    protected String firstName;
    protected String sureName;


    // State birth
    protected int standesamtNummer;
    protected int registerNumber;
    protected int birthYear;


    // State citizen
    protected String address;
    protected String taxID;


    //
    // Begin of Stages
    //

    public interface New {
        Born birthWeight(final double weight);
    }

    public interface Born {
        Register birthday(final LocalDate birthday);
    }

    public interface Register {
        Register firstName(final String firstName);

        Register sureName(final String sureName);

        Registered register(final int registerNummer);
    }

    public interface Registered {
        StagedPerson build();
    }

    interface Stages extends New, Born, Register, Registered {

    }

    //
    // Begin of Builder
    //

    public static class StagedPersonBuilder implements Stages {

        final StagedPerson person;

        public StagedPersonBuilder() {
            person = new StagedPerson();
        }


        @Override
        public Born birthWeight(double birthWeight) {
            if (birthWeight < 0.1) throw new IllegalArgumentException("birthWeight must be greather then 100g !");
            person.birthWeight = birthWeight;
            return this;
        }

        @Override
        public Register birthday(LocalDate birthday) {
            if (birthday == null) throw new IllegalArgumentException("birthday must be not null");
            person.birthday = birthday;
            return this;
        }

        @Override
        public Register firstName(String firstName) {
            if (StringUtils.isEmpty(firstName)) throw new IllegalArgumentException("firstName must be not null");
            person.firstName = firstName;
            return this;
        }

        @Override
        public Register sureName(String sureName) {
            if (StringUtils.isEmpty(sureName)) throw new IllegalArgumentException("sureName must be not null");
            person.sureName = sureName;
            return this;
        }

        @Override
        public Registered register(int registerNumber) {
            if (registerNumber < 1) throw new IllegalArgumentException("registerNumber must be greather then 0!");
            person.registerNumber = registerNumber;
            return this;
        }

        @Override
        public StagedPerson build() {
            return person;
        }

    }

}
