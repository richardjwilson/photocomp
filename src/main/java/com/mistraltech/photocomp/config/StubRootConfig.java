package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.StubCompetitionConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("stub")
public class StubRootConfig {
    @Bean
    public CompetitionConfigRepository competitionConfigRepositoryStub() {
        return new StubCompetitionConfigRepository();
    }
}
