package com.github.huluvu424242.legacyperson;

import java.time.LocalDate;

// NewStage -> BornStage -> RegisterStage -> RegisteredStage
public interface BuilderStages {
    LegacyPerson getPerson();

    interface NewStage extends BuilderStages {

        default BornStage birthWeight(double birthWeight) {
            final LegacyPerson person = getPerson();
            if (birthWeight < 0.1) throw new IllegalArgumentException("birthWeight must be greather then 100g !");
            person.birthWeight = birthWeight;
            return this::getPerson;
        }

    }

    interface BornStage extends BuilderStages {

        default RegisterStage birthday(LocalDate birthday) {
            final LegacyPerson person = getPerson();
            if (birthday == null) throw new IllegalArgumentException("birthday must be not null");
            person.birthday = birthday;
            return this::getPerson;
        }

    }

    interface RegisterStage extends BuilderStages {

        default RegisterStage firstName(String firstName) {
            final LegacyPerson person = getPerson();
            if (firstName == null) throw new IllegalArgumentException("firstName must be not null");
            person.firstName = firstName;
            return this::getPerson;
        }

        default RegisterStage sureName(String sureName) {
            final LegacyPerson person = getPerson();
            if (sureName == null) throw new IllegalArgumentException("sureName must be not null");
            person.sureName = sureName;
            return this::getPerson;
        }

        default RegisteredStage register(int registerNumber) {
            final LegacyPerson person = getPerson();
            if (registerNumber < 1) throw new IllegalArgumentException("registerNumber must be greather then 0!");
            person.registerNumber = registerNumber;
            return this::getPerson;
        }

        interface RegisteredStage extends BuilderStages {
            default LegacyPerson build() {
                return getPerson();
            }
        }

    }

}
