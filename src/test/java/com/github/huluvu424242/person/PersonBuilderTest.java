package com.github.huluvu424242.person;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonBuilderTest {

    @Test
    @DisplayName("Erzeugt eine gültige Person ohne Adresse")
    void initPerson() {
        final Person person = new Person.PersonBuilder()
                .birthday(LocalDate.of(1969, 1, 1))
                .firstname("Maik")
                .surename("Kalauer")
                .address("Schildbürgerstr. 8, Siebensanden")
                .build();
        assertNotNull(person);
        assertNotNull(person.address);
    }

    @Test
    @DisplayName("Erzeugt eine gültige Person ohne Adresse")
    void initObdachlosePerson() {
        final Person person = new Person.PersonBuilder()
                .birthday(LocalDate.of(1969, 1, 1))
                .firstname("No")
                .surename("Body")
                .build();
        assertNotNull(person);
        assertNull(person.address);
    }

    @Test
    @DisplayName("Erzeugt eine ungültige Person ohne Geburtsdatum")
    void initInvalidPerson() {
        final Person.PersonBuilder builder = new Person.PersonBuilder()
                .firstname("Arno")
                .surename("Nym")
                .address("Heinzelmannstr. 8, Mainz");
        assertNotNull(builder);
        assertThrows(NullPointerException.class, builder::build);
    }
}