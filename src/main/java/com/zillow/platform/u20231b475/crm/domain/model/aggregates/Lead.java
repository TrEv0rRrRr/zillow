package com.zillow.platform.u20231b475.crm.domain.model.aggregates;

import com.zillow.platform.u20231b475.crm.domain.model.commands.CreateLeadCommand;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.ContactInfo;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.EmailAddress;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadSource;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadStatus;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.Money;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.PersonalInfo;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.PurchaseIntent;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.SellerId;
import com.zillow.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

/**
 * Lead Aggregate root
 * 
 * @author Valentino Solis
 */
@Entity
@Getter
public class Lead extends AuditableAbstractAggregateRoot<Lead> {
  @Embedded
  private SellerId sellerId;

  @Embedded
  private EmailAddress email;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "age", column = @Column(name = "age")),
      @AttributeOverride(name = "incomeLevel", column = @Column(name = "income_level"))
  })
  private PersonalInfo personalInfo;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "fullName", column = @Column(name = "full_name")),
      @AttributeOverride(name = "phone", column = @Column(name = "phone"))
  })
  private ContactInfo contactInfo;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "locationPreference", column = @Column(name = "location_preference")),
      @AttributeOverride(name = "minBedrooms", column = @Column(name = "min_bedrooms"))
  })
  private PurchaseIntent purchaseIntent;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "amount", column = @Column(name = "amount")),
      @AttributeOverride(name = "currency", column = @Column(name = "currency"))
  })
  private Money bugdet;

  @Enumerated(EnumType.STRING)
  private LeadSource source;

  @Enumerated(EnumType.STRING)
  private LeadStatus status;

  public Lead() {
  }

  public Lead(CreateLeadCommand command) {
    this.sellerId = new SellerId(command.sellerId());
    this.email = new EmailAddress(command.email());
    this.personalInfo = new PersonalInfo(command.age(), command.incomeLevel());
    this.contactInfo = new ContactInfo(command.fullName(), command.phone());
    this.purchaseIntent = new PurchaseIntent(command.locationPreference(), command.minBedrooms());
    this.bugdet = new Money(command.amount(), command.currency());
    this.source = command.source();
    this.status = LeadStatus.NEW;
  }
}
