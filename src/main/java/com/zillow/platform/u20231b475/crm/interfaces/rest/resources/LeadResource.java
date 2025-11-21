package com.zillow.platform.u20231b475.crm.interfaces.rest.resources;

import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.ContactInfo;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.EmailAddress;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadSource;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadStatus;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.Money;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.PersonalInfo;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.PurchaseIntent;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.SellerId;

/**
 * Resource for a lead
 */
public record LeadResource(Long id, SellerId sellerId, EmailAddress email, ContactInfo contactInfo,
    PersonalInfo personalInfo, PurchaseIntent purchaseIntent, Money budget, LeadSource source, LeadStatus status) {
}
