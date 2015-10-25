package com.mistraltech.photocomp.controllers.competition.config.dto;

public class CompetitionConfigDto {
    private String competitionName;
    private String adminTitle;
    private String adminForename;
    private String adminSurname;

    public CompetitionConfigDto() {
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getAdminTitle() {
        return adminTitle;
    }

    public void setAdminTitle(String adminTitle) {
        this.adminTitle = adminTitle;
    }

    public String getAdminForename() {
        return adminForename;
    }

    public void setAdminForename(String adminForename) {
        this.adminForename = adminForename;
    }

    public String getAdminSurname() {
        return adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }
}
