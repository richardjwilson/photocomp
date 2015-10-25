package com.mistraltech.photocomp.controllers.competition.config.dto;

import org.junit.Test;

import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoLike;
import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCompetitionConfigDto {
    @Test
    public void canConstruct() {
        final CompetitionConfigDto competitionConfigDto = new CompetitionConfigDto();

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoThat()
                .hasAdminTitle(nullValue())
                .hasAdminForename(nullValue())
                .hasAdminSurname(nullValue())));
    }

    @Test
    public void canSetAdminTitle() {
        final CompetitionConfigDto competitionConfigDto = new CompetitionConfigDto();
        final CompetitionConfigDto defaultCompetitionConfigDto = new CompetitionConfigDto();

        competitionConfigDto.setAdminTitle("title");

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoLike(defaultCompetitionConfigDto)
                .hasAdminTitle("title")));
    }

    @Test
    public void canSetAdminForename() {
        final CompetitionConfigDto competitionConfigDto = new CompetitionConfigDto();
        final CompetitionConfigDto defaultCompetitionConfigDto = new CompetitionConfigDto();

        competitionConfigDto.setAdminForename("forename");

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoLike(defaultCompetitionConfigDto)
                .hasAdminForename("forename")));
    }

    @Test
    public void canSetAdminSurname() {
        final CompetitionConfigDto competitionConfigDto = new CompetitionConfigDto();
        final CompetitionConfigDto defaultCompetitionConfigDto = new CompetitionConfigDto();

        competitionConfigDto.setAdminSurname("surname");

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoLike(defaultCompetitionConfigDto)
                .hasAdminSurname("surname")));
    }
}
