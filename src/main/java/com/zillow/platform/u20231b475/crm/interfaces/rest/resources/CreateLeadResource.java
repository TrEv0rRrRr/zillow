package com.zillow.platform.u20231b475.crm.interfaces.rest.resources;

import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadSource;

import jakarta.validation.constraints.*;

/**
 * Resource for creating a lead
 */
public record CreateLeadResource(
    @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email,
    @NotNull(message = "Age is required") @Min(18) @Max(100) Integer age,
    @NotNull(message = "Income level is required") @Min(1) Integer incomeLevel,
    @NotBlank(message = "Full name is required") String fullName,
    Integer phone, String locationPreference,
    @NotNull(message = "the minimum number of rooms is required") @Min(1) Integer minBedrooms,
    @NotNull(message = "Amount is required") @Min(value = 5000, message = "Amount must be at least 5000") Integer amount,
    @NotNull(message = "currency is required") String currency,
    LeadSource source) {

  public CreateLeadResource {
    if (currency != null && !"USD".equals(currency.trim()))
      throw new IllegalArgumentException("Currency must be 'USD'. Received: '" + currency + "'");
  }
}
