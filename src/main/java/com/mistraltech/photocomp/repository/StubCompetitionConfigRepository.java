package com.mistraltech.photocomp.repository;

import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("competitionConfigRepository")
public class StubCompetitionConfigRepository implements CompetitionConfigRepository {

    private CompetitionConfig config = new CompetitionConfig("My Competition",
            new PersonName(Optional.empty(), "admin", Optional.empty()));

    @Override
    public CompetitionConfig getConfig() {
        return config;
    }

    @Override
    public CompetitionConfig save(CompetitionConfig competitionConfig) {
        this.config = competitionConfig;
        return competitionConfig;
    }
}
