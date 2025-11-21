package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Purchase Intent VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record PurchaseIntent(String locationPreference, @NotNull @Min(1) Integer minBedrooms) {
}
