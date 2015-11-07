package com.mistraltech.photocomp.controllers.competition.config.dto;

import org.junit.Before;
import org.junit.Test;

import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoLike;
import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompetitionConfigDtoTest {

    private CompetitionConfigDto competitionConfigDto;
    private CompetitionConfigDto defaultCompetitionConfigDto;

    @Before
    public void setUp() {
        competitionConfigDto = new CompetitionConfigDto();
        defaultCompetitionConfigDto = new CompetitionConfigDto();
    }

    @Test
    public void canConstruct() {
        assertThat(competitionConfigDto, is(aCompetitionConfigDtoThat()
                .hasAdminTitle(nullValue())
                .hasAdminForename(nullValue())
                .hasAdminSurname(nullValue())));
    }

    @Test
    public void canSetAdminTitle() {
        competitionConfigDto.setAdminTitle("title");

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoLike(defaultCompetitionConfigDto)
                .hasAdminTitle("title")));
    }

    @Test
    public void canSetAdminForename() {
        competitionConfigDto.setAdminForename("forename");

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoLike(defaultCompetitionConfigDto)
                .hasAdminForename("forename")));
    }

    @Test
    public void canSetAdminSurname() {
        competitionConfigDto.setAdminSurname("surname");

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoLike(defaultCompetitionConfigDto)
                .hasAdminSurname("surname")));
    }
}
