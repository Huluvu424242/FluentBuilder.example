package com.github.huluvu424242.stagedperson;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StagedPersonTest {
    @Test
    void createPersonNew() {
        final LocalDate now = LocalDate.now();
        final StagedPerson person = new StagedPerson.StagedPersonBuilder()
                .birthWeight(0.7)
                .birthday(now)
                .firstName("Arno")
                .sureName("Nym")
                .register(4718161)
                .build();
        assertNotNull(person);
        assertEquals(0.7, person.getBirthWeight());
        assertEquals(now, person.getBirthday());
        assertEquals("Arno", person.getFirstName());
        assertEquals("Nym", person.getSureName());
        assertEquals(4718161, person.getRegisterNumber());
    }

}