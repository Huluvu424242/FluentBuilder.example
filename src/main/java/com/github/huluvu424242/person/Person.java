package com.github.huluvu424242.person;

import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDate;

@Builder
public class Person {
    @NonNull
    protected LocalDate birthday;

    @NonNull
    protected String firstname;
    @NonNull
    protected String surename;

    protected String address;


}
