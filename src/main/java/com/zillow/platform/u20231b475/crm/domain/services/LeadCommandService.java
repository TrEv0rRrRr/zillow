package com.zillow.platform.u20231b475.crm.domain.services;

import java.util.Optional;

import com.zillow.platform.u20231b475.crm.domain.model.aggregates.Lead;
import com.zillow.platform.u20231b475.crm.domain.model.commands.CreateLeadCommand;

/**
 * Lead Command Service
 * 
 * @author Valentino Solis
 */
public interface LeadCommandService {

  /**
   * Handle create a Lead
   * 
   * @param command The {@link CreateLeadCommand} command
   * @return A {@link Lead} instance if the command is valid, otherwise false
   * @throws IllegalArgumentException if the lead already exists
   */
  Optional<Lead> handle(CreateLeadCommand command);
}
