package com.mistraltech.photocomp.repository;

import com.mistraltech.photocomp.model.CompetitionConfig;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface CompetitionConfigRepository extends Repository<CompetitionConfig, UUID> {
  CompetitionConfig getConfig();

  CompetitionConfig save(CompetitionConfig competitionConfig);
}
