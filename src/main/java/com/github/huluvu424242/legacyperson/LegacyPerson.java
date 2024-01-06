package com.github.huluvu424242.legacyperson;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LegacyPerson {

    LegacyPerson() {
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
}
