package com.mistraltech.photocomp.controllers.competition.config.dto;

import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.model.PersonName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Qualifier("competitionConfigDtoConverter")
public class CompetitionConfigDtoConverter {
    public CompetitionConfigDto toDto(CompetitionConfig competitionConfig) {
        final CompetitionConfigDto competitionConfigDto = new CompetitionConfigDto();
        competitionConfigDto.setCompetitionName(competitionConfig.getCompetitionName());
        competitionConfigDto.setAdminTitle(competitionConfig.getAdministratorName().getTitle().orElse(null));
        competitionConfigDto.setAdminForename(competitionConfig.getAdministratorName().getForename());
        competitionConfigDto.setAdminSurname(competitionConfig.getAdministratorName().getSurname().orElse(null));
        return competitionConfigDto;
    }

    public CompetitionConfig toModel(CompetitionConfigDto competitionConfigDto) {
        PersonName adminName = new PersonName(
                Optional.ofNullable(competitionConfigDto.getAdminTitle()),
                competitionConfigDto.getAdminForename(),
                Optional.ofNullable(competitionConfigDto.getAdminSurname()));

        CompetitionConfig updatedCompetitionConfig = new CompetitionConfig(
                competitionConfigDto.getCompetitionName(),
                adminName);

        return updatedCompetitionConfig;
    }
}
