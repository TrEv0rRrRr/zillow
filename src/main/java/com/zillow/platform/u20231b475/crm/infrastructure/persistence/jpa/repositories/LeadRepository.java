package com.zillow.platform.u20231b475.crm.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u20231b475.crm.domain.model.aggregates.Lead;
import com.zillow.platform.u20231b475.crm.domain.model.valueobjects.LeadSource;

/**
 * Lead Repository
 * 
 * @author Valentino Solis
 */
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
  /**
   * Find a lead by email and source
   * 
   * @param email  The email
   * @param source The lead source
   * @return A {@link Lead} instance if the provided properties are valid,
   *         otherwise empty
   * 
   * @author Valentino Solis
   */
  Optional<Lead> findByEmailAndSource(String email, LeadSource source);

  /**
   * Check if a lead exists by the given properties
   * 
   * @param email  The email
   * @param source The lead source
   * @return True if the Lead exists, otherwise false
   */
  boolean existsByEmailAndSource(String email, LeadSource source);
}
