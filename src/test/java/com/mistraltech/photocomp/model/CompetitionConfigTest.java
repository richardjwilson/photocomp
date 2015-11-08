package com.mistraltech.photocomp.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class CompetitionConfigTest {
    private final PersonName administratorName =
            new PersonName(Optional.of("title"), "forename", Optional.of("surname"));
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canConstruct() {
        final CompetitionConfig competitionConfig = new CompetitionConfig("comp", administratorName);

        assertThat(competitionConfig, is(CompetitionConfigMatcher.aCompetitionConfigThat()
                .hasCompetitionName("comp")
                .hasAdministratorName(administratorName)));
    }

    @Test
    public void cannotConstructWithNullCompetitionName() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("CompetitionName must not be null");

        new CompetitionConfig(null, administratorName);
    }

    @Test
    public void cannotConstructWithNullAdministratorName() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("AdministratorName must not be null");

        new CompetitionConfig("comp", null);
    }

    @Test
    public void overridesToString() {
        final CompetitionConfig competitionConfig = new CompetitionConfig("comp", administratorName);
        assertThat(competitionConfig.toString(), startsWith("CompetitionConfig{"));
        assertThat(competitionConfig.toString(), endsWith("}"));
    }
}