package com.mistraltech.photocomp.controllers.competition.config.dto;

public final class CompetitionConfigDtoBuilder {
    private String competitionName;
    private String adminTitle;
    private String adminForename;
    private String adminSurname;

    private CompetitionConfigDtoBuilder() {
        competitionName = "MyComp";
        adminTitle = "Lady";
        adminForename = "Penelope";
        adminSurname = "Pitstop";
    }

    public static CompetitionConfigDtoBuilder aCompetitionConfigDto() {
        return new CompetitionConfigDtoBuilder();
    }

    public CompetitionConfigDtoBuilder withCompetitionName(String competitionName) {
        this.competitionName = competitionName;
        return this;
    }

    public CompetitionConfigDtoBuilder withAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle;
        return this;
    }

    public CompetitionConfigDtoBuilder withAdminForename(String adminForename) {
        this.adminForename = adminForename;
        return this;
    }

    public CompetitionConfigDtoBuilder withAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
        return this;
    }

    public CompetitionConfigDtoBuilder but() {
        return aCompetitionConfigDto().withCompetitionName(competitionName).withAdminTitle(adminTitle)
                .withAdminForename(adminForename).withAdminSurname(adminSurname);
    }

    public CompetitionConfigDto build() {
        CompetitionConfigDto competitionConfigDto = new CompetitionConfigDto();
        competitionConfigDto.setCompetitionName(competitionName);
        competitionConfigDto.setAdminTitle(adminTitle);
        competitionConfigDto.setAdminForename(adminForename);
        competitionConfigDto.setAdminSurname(adminSurname);
        return competitionConfigDto;
    }
}
