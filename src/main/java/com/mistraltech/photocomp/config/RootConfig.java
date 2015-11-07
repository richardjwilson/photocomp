package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.StubCompetitionConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RootConfig {

    @Bean
    @Profile("stub")
    public CompetitionConfigRepository competitionConfigRepositoryStub() {
        return new StubCompetitionConfigRepository();
    }

    @Bean
    @Profile("!stub")
    public CompetitionConfigRepository competitionConfigRepository() {
        // Replace with real repository
        return new StubCompetitionConfigRepository();
    }
}
