package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Money VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record Money(
    @NotNull(message = "Amount is required") @Min(value = 5000, message = "Amount must be at least 5000") Integer amount,
    @NotNull(message = "currency is required") String currency) {

  public Money {
    if (currency != null && !"USD".equals(currency.trim()))
      throw new IllegalArgumentException("Currency must be 'USD'. Received: '" + currency + "'");
  }
}
