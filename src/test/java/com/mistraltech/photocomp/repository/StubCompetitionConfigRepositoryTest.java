package com.mistraltech.photocomp.repository;

import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static com.mistraltech.photocomp.model.CompetitionConfigMatcher.aCompetitionConfigLike;
import static com.mistraltech.photocomp.model.CompetitionConfigMatcher.aCompetitionConfigThat;
import static com.mistraltech.photocomp.model.PersonNameMatcher.aPersonNameThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StubCompetitionConfigRepositoryTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void canGetDefaultConfig() throws Exception {
        final StubCompetitionConfigRepository competitionConfigRepository = new StubCompetitionConfigRepository();

        final CompetitionConfig config = competitionConfigRepository.getConfig();

        assertThat(config, is(aCompetitionConfigThat()
                .hasAdministratorName(aPersonNameThat()
                        .hasTitle(Optional.empty())
                        .hasForename("admin")
                        .hasSurname(Optional.empty()))
                .hasCompetitionName("My Competition")));
    }

    @Test
    public void saveUpdatesConfig() throws Exception {
        final StubCompetitionConfigRepository competitionConfigRepository = new StubCompetitionConfigRepository();

        PersonName adminName = new PersonName(Optional.of("title"), "forename", Optional.of("surname"));
        CompetitionConfig updatedCompetitionConfig = new CompetitionConfig(
                "Updated Competition",
                adminName);

        competitionConfigRepository.save(updatedCompetitionConfig);

        final CompetitionConfig config = competitionConfigRepository.getConfig();

        assertThat(config, is(aCompetitionConfigThat()
                .hasAdministratorName(aPersonNameThat()
                        .hasTitle(Optional.of("title"))
                        .hasForename("forename")
                        .hasSurname(Optional.of("surname")))
                .hasCompetitionName("Updated Competition")));
    }

    @Test
    public void saveReturnsUpdatedConfig() throws Exception {
        final StubCompetitionConfigRepository competitionConfigRepository = new StubCompetitionConfigRepository();

        PersonName adminName = new PersonName(Optional.of("title"), "forename", Optional.of("surname"));
        CompetitionConfig updatedCompetitionConfig = new CompetitionConfig(
                "Updated Competition",
                adminName);

        final CompetitionConfig config = competitionConfigRepository.save(updatedCompetitionConfig);

        assertThat(config, is(aCompetitionConfigLike(competitionConfigRepository.getConfig())));
    }
}
