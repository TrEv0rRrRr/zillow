package com.zillow.platform.u20231b475.crm.interfaces.rest.transform;

import com.zillow.platform.u20231b475.crm.domain.model.commands.CreateLeadCommand;
import com.zillow.platform.u20231b475.crm.interfaces.rest.resources.CreateLeadResource;

/**
 * Assembler to convert a CreateLeadResource to a CreateLeadCommand.
 */
public class CreateLeadCommandFromResourceAssembler {
  /**
   * Converts a CreateLeadResource to a CreateLeadCommand
   * 
   * @param sellerId The seller Id
   * @param resource The {@link CreateLeadResource} resource to convert
   * @return The {@link CreateLeadCommand} command
   */
  public static CreateLeadCommand toCommandFromResource(Long sellerId, CreateLeadResource resource) {
    return new CreateLeadCommand(
        sellerId,
        resource.email(),
        resource.age(),
        resource.incomeLevel(),
        resource.fullName(),
        resource.phone(),
        resource.locationPreference(),
        resource.minBedrooms(),
        resource.amount(),
        resource.currency(),
        resource.source());
  }
}
