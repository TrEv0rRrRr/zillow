package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Seller Id VO
 * 
 * @author Valentino Solis
 */
public record SellerId(@NotNull(message = "Seller Id is required") @Min(1) Long id) {
}
