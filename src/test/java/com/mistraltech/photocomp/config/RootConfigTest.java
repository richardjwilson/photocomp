package com.mistraltech.photocomp.config;

import com.mistraltech.photocomp.repository.CompetitionConfigRepository;
import com.mistraltech.photocomp.repository.StubCompetitionConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class, loader = AnnotationConfigContextLoader.class)
public class RootConfigTest {

    @Autowired
    private CompetitionConfigRepository competitionConfigRepository;

    @Test
    public void ensureStubCompetitionConfigRepositoryIsLoaded() {
        assertThat(competitionConfigRepository, is(instanceOf(StubCompetitionConfigRepository.class)));
    }
}
