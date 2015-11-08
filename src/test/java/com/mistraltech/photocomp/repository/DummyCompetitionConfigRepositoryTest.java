package com.mistraltech.photocomp.repository;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class DummyCompetitionConfigRepositoryTest {

    @Test
    public void getConfigReturnsNull() throws Exception {
        assertThat(new DummyCompetitionConfigRepository().getConfig(), is(nullValue()));
    }

    @Test
    public void saveDoesNothing() throws Exception {
        new DummyCompetitionConfigRepository().save(null);
    }
}