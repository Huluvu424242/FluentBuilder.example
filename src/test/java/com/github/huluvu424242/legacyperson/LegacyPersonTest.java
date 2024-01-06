package com.github.huluvu424242.legacyperson;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LegacyPersonTest {


    LocalDate now1;
    LocalDate now2;

    @BeforeEach
    void setUp() {
        this.now1 = LocalDate.now();
        this.now2 = LocalDate.now();
    }

    @Test
    void createPersonNew() {
        final LegacyPerson person = LegacyPersonBuilder.builder()
                .birthWeight(0.7)
                .birthday(now1)
                .firstName("Arno")
                .sureName("Nym")
                .register(4718161)
                .build();
        assertNotNull(person);
        assertEquals(0.7, person.getBirthWeight());
        assertEquals(now1, person.getBirthday());
        assertEquals("Arno", person.getFirstName());
        assertEquals("Nym", person.getSureName());
        assertEquals(4718161, person.getRegisterNumber());
    }

    @Test
    void create2PersonNew() {

        final BuilderStages.RegisterStage builder1 = LegacyPersonBuilder.builder()
                .birthWeight(0.7)
                .birthday(now1)
                .firstName("Arno");

        final BuilderStages.RegisterStage builder2 = LegacyPersonBuilder.builder()
                .birthWeight(0.8)
                .birthday(now2)
                .firstName("Anno");


        final LegacyPerson person1 = builder1
                .sureName("Nym")
                .register(4718161)
                .build();

        final LegacyPerson person2 = builder2
                .sureName("Nymos")
                .register(12345)
                .build();

        checkValues(person1, person2);

    }

    void checkValues(final LegacyPerson person1, final LegacyPerson person2) {
        // Person 1
        assertNotNull(person1);
        assertEquals(0.7, person1.getBirthWeight());
        assertEquals(now1, person1.getBirthday());
        assertEquals("Arno", person1.getFirstName());
        assertEquals("Nym", person1.getSureName());
        assertEquals(4718161, person1.getRegisterNumber());
        // Person 2
        assertNotNull(person1);
        assertEquals(0.8, person2.getBirthWeight());
        assertEquals(now1, person2.getBirthday());
        assertEquals("Anno", person2.getFirstName());
        assertEquals("Nymos", person2.getSureName());
        assertEquals(12345, person2.getRegisterNumber());
    }

}