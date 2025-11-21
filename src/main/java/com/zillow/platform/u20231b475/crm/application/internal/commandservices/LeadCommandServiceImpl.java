package com.zillow.platform.u20231b475.crm.application.internal.commandservices;

import java.util.Optional;

import com.zillow.platform.u20231b475.crm.domain.model.aggregates.Lead;
import com.zillow.platform.u20231b475.crm.domain.model.commands.CreateLeadCommand;
import com.zillow.platform.u20231b475.crm.domain.services.LeadCommandService;
import com.zillow.platform.u20231b475.crm.infrastructure.persistence.jpa.repositories.LeadRepository;

/**
 * Lead command service implementation
 * 
 * @author Valentino Solis
 */
public class LeadCommandServiceImpl implements LeadCommandService {
  private final LeadRepository repo;

  public LeadCommandServiceImpl(LeadRepository repo) {
    this.repo = repo;
  }

  // inherited javadoc
  @Override
  public Optional<Lead> handle(CreateLeadCommand command) {
    if (repo.existsByEmailAndSource(command.email(), command.source())) {
      throw new IllegalArgumentException("A lead with this email and source already exists.");
    }

    var lead = new Lead(command);
    repo.save(lead);
    return Optional.of(lead);
  }
}
