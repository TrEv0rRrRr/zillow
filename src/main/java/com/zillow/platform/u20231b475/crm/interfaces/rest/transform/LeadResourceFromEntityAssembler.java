package com.zillow.platform.u20231b475.crm.interfaces.rest.transform;

import com.zillow.platform.u20231b475.crm.domain.model.aggregates.Lead;
import com.zillow.platform.u20231b475.crm.interfaces.rest.resources.LeadResource;

/**
 * Assembler to convert a Lead entity to a LeadResource
 * 
 * @author Valentino Solis
 */
public class LeadResourceFromEntityAssembler {

  /**
   * Converts a Lead entity to tan LeadResource
   * 
   * @param entity The {@link Lead} entity to convert
   * @return The {@link LeadResource} resource
   */
  public static LeadResource toResourceFromEntity(Lead entity) {
    return new LeadResource(
        entity.getId(),
        entity.getSellerId(),
        entity.getEmail(),
        entity.getContactInfo(),
        entity.getPersonalInfo(),
        entity.getPurchaseIntent(),
        entity.getBugdet(),
        entity.getSource(),
        entity.getStatus());
  }
}
