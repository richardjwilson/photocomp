package com.mistraltech.photocomp.controllers.competition.config.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompetitionConfigDto {

    @NotNull @Size(min = 1)
    private String competitionName;

    private String adminTitle;

    @NotNull @Size(min = 1)
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

    @Override
    public String toString() {
        return "CompetitionConfigDto{" +
                "competitionName='" + competitionName + '\'' +
                ", adminTitle='" + adminTitle + '\'' +
                ", adminForename='" + adminForename + '\'' +
                ", adminSurname='" + adminSurname + '\'' +
                '}';
    }
}
