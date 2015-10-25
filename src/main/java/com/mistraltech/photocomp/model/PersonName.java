package com.mistraltech.photocomp.model;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class PersonName {
    private Optional<String> title;
    private String forename;
    private Optional<String> surname;

    public PersonName(Optional<String> title, String forename, Optional<String> surname) {

        this.title = requireNonNull(title, "Title must not be null");
        this.forename = requireNonNull(forename, "Forename must not be null");
        this.surname = requireNonNull(surname, "Surname must not be null");
    }

    public Optional<String> getTitle() {
        return title;
    }

    public String getForename() {
        return forename;
    }

    public Optional<String> getSurname() {
        return surname;
    }
}
