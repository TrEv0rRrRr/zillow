package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

/**
 * Contact Info VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record ContactInfo(@NotBlank String fullName, Integer phone) {
}
