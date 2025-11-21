package com.zillow.platform.u20231b475.crm.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zillow.platform.u20231b475.crm.domain.services.LeadCommandService;
import com.zillow.platform.u20231b475.crm.interfaces.rest.resources.CreateLeadResource;
import com.zillow.platform.u20231b475.crm.interfaces.rest.resources.LeadResource;
import com.zillow.platform.u20231b475.crm.interfaces.rest.transform.CreateLeadCommandFromResourceAssembler;
import com.zillow.platform.u20231b475.crm.interfaces.rest.transform.LeadResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Lead Controller
 */
@RestController
@RequestMapping(value = "/api/v1/sellers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Leads", description = "Available Leads Endpoints")
public class LeadController {
  private final LeadCommandService service;

  /**
   * Constructor
   * 
   * @param service The {@link LeadCommandService} instance
   */
  public LeadController(LeadCommandService service) {
    this.service = service;
  }

  @PostMapping("/{sellerId}/leads")
  @Operation(summary = "Creates a new Lead")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Lead Created"),
      @ApiResponse(responseCode = "400", description = "Bad Request")
  })
  public ResponseEntity<LeadResource> createLead(@PathVariable Long sellerId,
      @Valid @RequestBody CreateLeadResource resource) {
    var createLeadCommand = CreateLeadCommandFromResourceAssembler.toCommandFromResource(sellerId, resource);

    var lead = service.handle(createLeadCommand);

    if (lead.isEmpty())
      return ResponseEntity.badRequest().build();

    var createdLead = lead.get();

    var leadResource = LeadResourceFromEntityAssembler.toResourceFromEntity(createdLead);

    return new ResponseEntity<>(leadResource, HttpStatus.CREATED);
  }
}
