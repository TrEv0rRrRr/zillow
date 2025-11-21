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
public record PurchaseIntent(@NotNull(message = "the minimum number of rooms is required") @Min(1) Integer minBedrooms,
        String locationPreference) {

    public PurchaseIntent(Integer minBedrooms) {
        this(minBedrooms, null);
    }
}
