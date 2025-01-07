package com.vishwa.owner_pet_management.controller;

import com.vishwa.owner_pet_management.dto.OwnerDTO;
import com.vishwa.owner_pet_management.exception.OwnerNotFoundException;
import com.vishwa.owner_pet_management.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    private OwnerService ownerService;

    // Save a new owner
    @PostMapping
    public ResponseEntity<String> saveOwner(@Valid @RequestBody OwnerDTO ownerDTO) {
        LOGGER.info("Request to save owner: {}", ownerDTO);
        ownerService.saveOwner(ownerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Owner saved successfully.");
    }

    // Get owner by ID
    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDTO> findOwner(@PathVariable int ownerId) {
        try {
            LOGGER.info("Fetching owner with ID: {}", ownerId);
            OwnerDTO ownerDTO = ownerService.findOwner(ownerId);
            return ResponseEntity.ok(ownerDTO);
        } catch (OwnerNotFoundException ex) {
            LOGGER.error("Owner not found: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Update pet details for an owner
    @PutMapping("/{ownerId}/pets")
    public ResponseEntity<String> updatePetDetails(
            @PathVariable int ownerId,
            @RequestParam String petName) {
        try {
            LOGGER.info("Updating pet details for owner ID: {} with pet name: {}", ownerId, petName);
            ownerService.updatePetDetails(ownerId, petName);
            return ResponseEntity.ok("Pet details updated successfully.");
        } catch (OwnerNotFoundException ex) {
            LOGGER.error("Failed to update pet details: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner not found.");
        }
    }

    // Delete an owner by ID
    @DeleteMapping("/{ownerId}")
    public ResponseEntity<String> deleteOwner(@PathVariable int ownerId) {
        try {
            LOGGER.info("Deleting owner with ID: {}", ownerId);
            ownerService.deleteOwner(ownerId);
            return ResponseEntity.ok("Owner deleted successfully.");
        } catch (OwnerNotFoundException ex) {
            LOGGER.error("Failed to delete owner: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Owner not found.");
        }
    }
}

