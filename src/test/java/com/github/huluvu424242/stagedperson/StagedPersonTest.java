package com.github.huluvu424242.stagedperson;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StagedPersonTest {
    @Test
    void createPersonNew() {
        final StagedPerson person = new StagedPerson.StagedPersonBuilder()
                .birthWeight(0.7)
                .birthday(LocalDate.now())
                .firstName("Arno")
                .sureName("Nym")
                .register(4718161)
                .build();
        assertNotNull(person);
    }

}