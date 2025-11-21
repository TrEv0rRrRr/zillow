package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

/**
 * Contact Info VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record ContactInfo(@NotBlank(message = "Full name is required") String fullName, Integer phone) {

  public ContactInfo(String fullName) {
    this(fullName, null);
  }
}
