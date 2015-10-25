package com.mistraltech.photocomp.model;


import static java.util.Objects.requireNonNull;

public class CompetitionConfig {
    private String competitionName;
    private PersonName administratorName;

    public CompetitionConfig(String competitionName, PersonName administratorName) {
        this.competitionName = requireNonNull(competitionName, "CompetitionName must not be null");
        this.administratorName = requireNonNull(administratorName, "AdministratorName must not be null");
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public PersonName getAdministratorName() {
        return administratorName;
    }
}
