package com.zillow.platform.u20231b475.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * EmailAddress VO
 * 
 * @author Valentino Solis
 */
@Embeddable
public record EmailAddress(
    @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email) {
}
