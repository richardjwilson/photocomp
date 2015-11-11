package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.photocomp.controllers.Converter;
import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompetitionConfigDtoToCompetitionConfigConverter
        implements Converter<CompetitionConfigDto, CompetitionConfig> {

    @Override
    public CompetitionConfig convert(CompetitionConfigDto source) {
        PersonName adminName = new PersonName(
                Optional.ofNullable(source.getAdminTitle()),
                source.getAdminForename(),
                Optional.ofNullable(source.getAdminSurname()));

        CompetitionConfig updatedCompetitionConfig = new CompetitionConfig(
                source.getCompetitionName(),
                adminName);

        return updatedCompetitionConfig;
    }
}
