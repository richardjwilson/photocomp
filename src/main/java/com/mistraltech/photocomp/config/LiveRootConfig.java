package com.mistraltech.photocomp.config;


import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.DummyCompetitionConfigRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("!stub")
public class LiveRootConfig {
    @Bean
    public CompetitionConfigRepository competitionConfigRepository() {
        // Replace with real repository
        return new DummyCompetitionConfigRepository();
    }
}
