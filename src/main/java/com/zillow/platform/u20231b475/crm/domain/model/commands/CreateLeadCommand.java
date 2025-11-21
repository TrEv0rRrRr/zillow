package com.zillow.platform.u20231b475.crm.domain.model.commands;

import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadSource;

/**
 * Command for leads creation
 * 
 * @author Valentino Solis
 */
public record CreateLeadCommand(Long sellerId, String email, Integer age, Integer incomeLevel, String fullName,
    Integer phone, String locationPreference, Integer minBedrooms, Integer amount, String currency,
    LeadSource source) {
}
