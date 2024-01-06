package com.github.huluvu424242.legacyperson;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LegacyPersonTest {
    @Test
    void createPersonNew() {
        final LocalDate now = LocalDate.now();
        final LegacyPerson person = LegacyPersonBuilder.builder()
                .birthWeight(0.7)
                .birthday(LocalDate.now())
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