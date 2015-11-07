package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDtoMatcher.aCompetitionConfigDtoThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompetitionConfigToCompetitionConfigDtoConverterTest {

    private CompetitionConfigToCompetitionConfigDtoConverter converter;

    @Before
    public void setUp() {
        converter = new CompetitionConfigToCompetitionConfigDtoConverter();
    }

    @Test
    public void canConvertToDto() {
        final PersonName administratorName = new PersonName(Optional.of("title"), "forename", Optional.of("surname"));
        final CompetitionConfig competitionConfig = new CompetitionConfig("comp", administratorName);

        final CompetitionConfigDto competitionConfigDto = converter.convert(competitionConfig);

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoThat()
                .hasCompetitionName("comp")
                .hasAdminTitle("title")
                .hasAdminForename("forename")
                .hasAdminSurname("surname")));
    }

    @Test
    public void canConvertToDtoWithoutOptionalValues() {
        final PersonName administratorName = new PersonName(Optional.empty(), "forename", Optional.empty());
        final CompetitionConfig competitionConfig = new CompetitionConfig("comp", administratorName);

        final CompetitionConfigDto competitionConfigDto = converter.convert(competitionConfig);

        assertThat(competitionConfigDto, is(aCompetitionConfigDtoThat()
                .hasCompetitionName("comp")
                .hasAdminTitle(nullValue())
                .hasAdminForename("forename")
                .hasAdminSurname(nullValue())));
    }
}
