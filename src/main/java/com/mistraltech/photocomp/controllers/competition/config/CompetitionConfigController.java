package com.mistraltech.photocomp.controllers.competition.config;

import com.mistraltech.photocomp.controllers.Converter;
import com.mistraltech.photocomp.controllers.competition.config.dto.CompetitionConfigDto;
import com.mistraltech.photocomp.model.CompetitionConfig;
import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/comp/config")
public class CompetitionConfigController {
    private Logger logger = LoggerFactory.getLogger(CompetitionConfigController.class);

    private CompetitionConfigRepository competitionConfigRepository;
    private Converter<CompetitionConfig, CompetitionConfigDto> modelToDtoConverter;
    private Converter<CompetitionConfigDto, CompetitionConfig> dtoToModelConverter;

    @Autowired
    public CompetitionConfigController(CompetitionConfigRepository competitionConfigRepository,
            Converter<CompetitionConfig, CompetitionConfigDto> modelToDtoConverter,
            Converter<CompetitionConfigDto, CompetitionConfig> dtoToModelConverter) {
        this.competitionConfigRepository = competitionConfigRepository;
        this.modelToDtoConverter = modelToDtoConverter;
        this.dtoToModelConverter = dtoToModelConverter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public CompetitionConfigDto getConfig() {
        logger.info("Processing get request for comp-config");

        CompetitionConfig storedCompetitionConfig = competitionConfigRepository.getConfig();

        return modelToDtoConverter.convert(storedCompetitionConfig);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<CompetitionConfigDto> updateConfig(
            @Valid @RequestBody CompetitionConfigDto competitionConfigDto) {
        logger.info("Processing put request for comp-config");

        CompetitionConfig updatedCompetitionConfig = dtoToModelConverter.convert(competitionConfigDto);
        CompetitionConfig storedCompetitionConfig = competitionConfigRepository.save(updatedCompetitionConfig);
        CompetitionConfigDto responseCompetitionConfigDto = modelToDtoConverter.convert(storedCompetitionConfig);

        return new ResponseEntity<>(responseCompetitionConfigDto, HttpStatus.OK);
    }
}
