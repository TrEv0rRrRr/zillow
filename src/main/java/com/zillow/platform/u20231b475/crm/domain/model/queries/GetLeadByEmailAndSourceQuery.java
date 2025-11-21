package com.zillow.platform.u20231b475.crm.domain.model.queries;

import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadSource;

/**
 * Query to retrieve a lead by its email and source
 */
public record GetLeadByEmailAndSourceQuery(String email, LeadSource source) {
}
