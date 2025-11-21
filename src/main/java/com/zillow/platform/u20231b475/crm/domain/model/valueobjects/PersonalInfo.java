package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Personal Info VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record PersonalInfo(@NotNull(message = "Age is required") @Min(18) @Max(100) Integer age,
    @NotNull(message = "Income level is required") @Min(1) Integer incomeLevel) {
}
