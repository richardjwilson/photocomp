package com.mistraltech.photocomp.model;

import static com.mistraltech.photocomp.model.PersonNameBuilder.aPersonName;

public final class CompetitionConfigBuilder {
    private String competitionName;
    private PersonName administratorName;

    private CompetitionConfigBuilder() {
        competitionName = "MyComp";
        administratorName = aPersonName().build();
    }

    public static CompetitionConfigBuilder aCompetitionConfig() {
        return new CompetitionConfigBuilder();
    }

    public CompetitionConfigBuilder withCompetitionName(String competitionName) {
        this.competitionName = competitionName;
        return this;
    }

    public CompetitionConfigBuilder withAdministratorName(PersonName administratorName) {
        this.administratorName = administratorName;
        return this;
    }

    public CompetitionConfigBuilder but() {
        return aCompetitionConfig().withCompetitionName(competitionName).withAdministratorName(administratorName);
    }

    public CompetitionConfig build() {
        CompetitionConfig competitionConfig = new CompetitionConfig(competitionName, administratorName);
        return competitionConfig;
    }
}
