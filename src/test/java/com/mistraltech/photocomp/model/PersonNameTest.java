package com.mistraltech.photocomp.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static com.mistraltech.photocomp.model.PersonNameMatcher.aPersonNameThat;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class PersonNameTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canConstruct() {
        final PersonName personName = new PersonName(Optional.of("title"), "forename", Optional.of("surname"));

        assertThat(personName, is(aPersonNameThat()
                .hasTitle(Optional.of("title"))
                .hasForename("forename")
                .hasSurname(Optional.of("surname"))));
    }

    @Test
    public void canConstructWithoutOptionalValues() {
        final PersonName personName = new PersonName(Optional.empty(), "forename", Optional.empty());

        assertThat(personName, is(aPersonNameThat()
                .hasTitle(Optional.empty())
                .hasForename("forename")
                .hasSurname(Optional.empty())));
    }

    @Test
    public void cannotConstructWithNullTitle() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Title must not be null");

        new PersonName(null, "forename", Optional.of("surname"));
    }

    @Test
    public void cannotConstructWithNullForename() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Forename must not be null");

        new PersonName(Optional.of("title"), null, Optional.of("surname"));
    }

    @Test
    public void cannotConstructWithNullSurname() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Surname must not be null");

        new PersonName(Optional.of("title"), "forename", null);
    }


    @Test
    public void overridesToString() {
        final PersonName personName = new PersonName(Optional.empty(), "forename", Optional.empty());

        assertThat(personName.toString(), startsWith("PersonName{"));
        assertThat(personName.toString(), endsWith("}"));
    }
}