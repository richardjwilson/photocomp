package com.mistraltech.photocomp.repository;

import com.mistraltech.photocomp.model.CompetitionConfig;

public class DummyCompetitionConfigRepository implements CompetitionConfigRepository {
    @Override
    public CompetitionConfig getConfig() {
        return null;
    }

    @Override
    public CompetitionConfig save(CompetitionConfig competitionConfig) {
        return null;
    }
}
