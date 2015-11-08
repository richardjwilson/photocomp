package com.mistraltech.photocomp.model;

import java.util.Optional;

public final class PersonNameBuilder {
    private Optional<String> title;
    private String forename;
    private Optional<String> surname;

    private PersonNameBuilder() {
        title = Optional.of("Prof");
        forename = "Albert";
        surname = Optional.of("Plum");
    }

    public static PersonNameBuilder aPersonName() {
        return new PersonNameBuilder();
    }

    public PersonNameBuilder withTitle(Optional<String> title) {
        this.title = title;
        return this;
    }

    public PersonNameBuilder withTitle(String title) {
        return withTitle(Optional.of(title));
    }

    public PersonNameBuilder withForename(String forename) {
        this.forename = forename;
        return this;
    }

    public PersonNameBuilder withSurname(Optional<String> surname) {
        this.surname = surname;
        return this;
    }

    public PersonNameBuilder withSurname(String surname) {
        return withSurname(Optional.of(surname));
    }

    public PersonNameBuilder but() {
        return aPersonName().withTitle(title).withForename(forename).withSurname(surname);
    }

    public PersonName build() {
        PersonName personName = new PersonName(title, forename, surname);
        return personName;
    }
}
