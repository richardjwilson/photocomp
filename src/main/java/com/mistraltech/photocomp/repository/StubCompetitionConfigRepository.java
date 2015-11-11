package com.mistraltech.photocomp.repository;

import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Repository
@Qualifier("competitionConfigRepository")
public class StubCompetitionConfigRepository implements CompetitionConfigRepository {

    private static final String COMPETITION_NAME = "My Competition";
    private static final Optional<String> TITLE = Optional.empty();
    private static final String FORENAME = "admin";
    private static final Optional<String> SURNAME = Optional.empty();

    private CompetitionConfig config;

    public StubCompetitionConfigRepository() {
        this.config = new CompetitionConfig(COMPETITION_NAME,
                new PersonName(TITLE, FORENAME, SURNAME));
    }

    @Override
    public CompetitionConfig getConfig() {
        return config;
    }

    @Override
    public CompetitionConfig save(CompetitionConfig competitionConfig) {
        this.config = requireNonNull(competitionConfig, "Configuration must not be null");
        return competitionConfig;
    }
}
